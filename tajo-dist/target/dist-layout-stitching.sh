run() {
                        echo "\$ ${@}"
                        "${@}"
                        res=$?
                        if [ $res != 0 ]; then
                          echo
                          echo "Failed!"
                          echo
                          exit $res
                        fi
                      }

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-dist/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-0.12.0-SNAPSHOT
                      run mkdir tajo-0.12.0-SNAPSHOT
                      run cd tajo-0.12.0-SNAPSHOT
                      run cp -r $ROOT/tajo-common/target/tajo-common-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-rpc/target/tajo-rpc-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-algebra/target/tajo-algebra-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-plan/target/tajo-plan-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-client/target/tajo-client-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-client-example/target/tajo-client-example-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-cli/target/tajo-cli-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-catalog/target/tajo-catalog-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-storage/target/tajo-storage-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-sql-parser/target/tajo-sql-parser-0.12.0-SNAPSHOT/* .
                      run cp -r $ROOT/tajo-storage/tajo-storage-jdbc/target/tajo-storage-jdbc-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-storage/tajo-storage-pgsql/target/tajo-storage-pgsql-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-storage/tajo-storage-mysql/target/tajo-storage-mysql-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-storage/tajo-storage-sundb/target/tajo-storage-sundb-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-pullserver/target/tajo-pullserver-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-metrics/target/tajo-metrics-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-core/target/tajo-core-0.12.0-SNAPSHOT.jar .
                      run cp -r $ROOT/tajo-core/target/lib .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-dist/src/main/bin .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-dist/src/main/conf .
                      run rm -rf lib/tajo-*-0.12.0-SNAPSHOT.jar

                      run mkdir -p lib
                      run cp -r $ROOT/tajo-storage/tajo-storage-hdfs/target/lib/hive-*.jar lib/
                      
                      run mkdir -p share/jdbc-dist
                      run cp -r $ROOT/tajo-jdbc/target/tajo-jdbc-0.12.0-SNAPSHOT-jar-with-dependencies.jar ./share/jdbc-dist/tajo-jdbc-0.12.0-SNAPSHOT.jar

                      run mkdir -p extlib

                      echo
                      echo "Tajo dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-dist/target/tajo-0.12.0-SNAPSHOT"
                      echo