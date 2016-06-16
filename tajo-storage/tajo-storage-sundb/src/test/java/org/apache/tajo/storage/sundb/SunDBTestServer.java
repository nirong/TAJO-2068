/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tajo.storage.sundb;

import io.nirong.testing.sundb.TestingSunDBServer;
import net.minidev.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.Path;
import org.apache.tajo.conf.TajoConf;
import org.apache.tajo.storage.Tablespace;
import org.apache.tajo.storage.TablespaceManager;
import org.apache.tajo.storage.jdbc.JdbcTablespace;
import org.apache.tajo.util.CommonTestingUtil;
import org.apache.tajo.util.FileUtil;
import org.apache.tajo.util.JavaResourceUtil;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

public class SunDBTestServer {
	  private static final Log LOG = LogFactory.getLog(SunDBTestServer.class);

	  private static final SunDBTestServer instance;

	  public static final String [] TPCH_TABLES = {
	      "customer", "lineitem", "nation", "orders", "part", "partsupp", "region", "supplier"
	  };

	  public static final String SPACENAME = "SunDB_cluster";
	  public static final String DATABASE_NAME = "test";
	  public static final String USERNAME = "TEST";
	  public static final String PASSWORD = "test";
	  public static final int PORT = 22222;

	  private final TestingSunDBServer server;

	  static {
	    try {
	      instance = new SunDBTestServer();
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	  }

	  public static SunDBTestServer getInstance() {
	    return instance;
	  }

	  private SunDBTestServer() throws Exception {
	    server = new TestingSunDBServer(USERNAME, PASSWORD, DATABASE_NAME, PORT);

	    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	      @Override
	      public void run() {
	        server.close();
	      }
	    }));

	    loadTPCHTables();
	    registerTablespace();
	  }

	  Path testPath = CommonTestingUtil.getTestDir();

	  private void loadTPCHTables() throws SQLException, IOException {

	    try (Connection connection = server.createConnectionByDriverManager(getJdbcUrl(), USERNAME, PASSWORD)) {
	      try (Statement statement = connection.createStatement()) {
//	        statement.execute(format("GRANT ALL ON %s.* TO '%s'@'%%' IDENTIFIED BY '%s'", DATABASE_NAME, "SunDB", "SunDB"));

	        for (String tableName : TPCH_TABLES) {
	          String sql = JavaResourceUtil.readTextFromResource("sundb/" + tableName + ".sql");
	          statement.execute(sql);

	          // restore the table contents into a file stored in a local file system for SunDB LOAD DATA command
	          String path = restoreTableContents(tableName);
	          String copyCommand = genLoadStatement(tableName, path);
	          statement.execute(copyCommand);
	        }

	        // load DATETIME_TYPES table
	        String sql = JavaResourceUtil.readTextFromResource("SunDB/datetime_types.sql");
	        statement.executeUpdate(sql);
	        Path filePath = new Path(testPath, "datetime_types.txt");
	        storeTableContents("sundb/datetime_types.txt", filePath);
	        String copyCommand = genLoadStatement("DATETIME_TYPES", filePath.toUri().getPath());
	        LOG.info(copyCommand);
	        statement.execute(copyCommand);

	      } catch (Throwable t) {
	        t.printStackTrace();
	        throw t;
	      }
	    }
	  }

	  private String genLoadStatement(String tableName, String path) {
	   return "LOAD DATA INFILE '" + path + "' INTO TABLE " + tableName + " FIELDS TERMINATED BY '|'";
	  }

	  private void storeTableContents(String resource, Path path) throws IOException {
	    String csvTable = JavaResourceUtil.readTextFromResource(resource);
	    String fixedCsvTable = fixExtraColumn(csvTable);
	    FileUtil.writeTextToFile(fixedCsvTable, path);
	  }

	  private String restoreTableContents(String tableName) throws IOException {
	    Path filePath = new Path(testPath, tableName + ".tbl");
	    storeTableContents("tpch/" + tableName + ".tbl", filePath);
	    return filePath.toUri().getPath();
	  }

	  private String fixExtraColumn(String csvTable) {
	    final String [] lines = csvTable.split("\n");
	    final StringBuilder rewritten = new StringBuilder();

	    for (String l : lines) {
	      if (l.charAt(l.length() - 1) == '|') {
	        rewritten.append(l.substring(0, l.length() - 1));
	      } else {
	        rewritten.append(l.substring(0, l.length()));
	      }
	      rewritten.append("\n");
	    }

	    return rewritten.toString();
	  }

	  private void registerTablespace() throws IOException {
	    JSONObject configElements = new JSONObject();
	    configElements.put(JdbcTablespace.CONFIG_KEY_MAPPED_DATABASE, DATABASE_NAME);

	    SunDBTablespace tablespace = new SunDBTablespace(SPACENAME, URI.create(getJdbcUrl()), configElements);
	    tablespace.init(new TajoConf());

	    TablespaceManager.addTableSpaceForTest(tablespace);
	  }

	  /**
	   * get JDBC URL for test server
	   *
	   * @return JDBC URL
	   */
	  public String getJdbcUrl() {
		  return server.getJdbcUrl();
//	    String[] url = server.getJdbcUrl().split("\\?");
//	    return url[0] + "/" + DATABASE_NAME + "?" + url[1];
	  }

	  public TestingSunDBServer getServer() {
	    return server;
	  }

	  public static Optional<Tablespace> resetAllParamsAndSetConnProperties(Map<String, String> connProperties)
	      throws IOException {
	    String uri = SunDBTestServer.getInstance().getJdbcUrl().split("\\?")[0];

	    JSONObject configElements = new JSONObject();
	    configElements.put(JdbcTablespace.CONFIG_KEY_MAPPED_DATABASE, SunDBTestServer.DATABASE_NAME);

	    JSONObject connPropertiesJson = new JSONObject();
	    for (Map.Entry<String, String> entry : connProperties.entrySet()) {
	      connPropertiesJson.put(entry.getKey(), entry.getValue());
	    }
	    configElements.put(JdbcTablespace.CONFIG_KEY_CONN_PROPERTIES, connPropertiesJson);

	    SunDBTablespace tablespace = new SunDBTablespace(SunDBTestServer.SPACENAME, URI.create(uri), configElements);
	    tablespace.init(new TajoConf());
	    return TablespaceManager.addTableSpaceForTest(tablespace);
	  }

	  public static void main(String[] args) throws Exception {
	  }
}
