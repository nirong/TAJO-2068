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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-catalog/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-catalog-0.12.0-SNAPSHOT
                      run mkdir tajo-catalog-0.12.0-SNAPSHOT
                      run cd tajo-catalog-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-catalog/tajo-catalog-common/target/tajo-catalog-common-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-catalog/tajo-catalog-client/target/tajo-catalog-client-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-catalog/tajo-catalog-server/target/tajo-catalog-server-0.12.0-SNAPSHOT*.jar .
                      if [ -f /home/phynix/workspace/TAJO-2068/tajo-catalog/tajo-catalog-drivers/tajo-hive/target/tajo-hive-0.12.0-SNAPSHOT.jar ]
                      then
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-catalog/tajo-catalog-drivers/tajo-hive/target/tajo-hive-0.12.0-SNAPSHOT*.jar .
                      fi
                      echo
                      echo "Tajo Catalog dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-catalog/target/tajo-catalog-0.12.0-SNAPSHOT"
                      echo