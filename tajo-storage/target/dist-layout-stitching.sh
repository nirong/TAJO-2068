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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-storage/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-storage-0.12.0-SNAPSHOT
                      run mkdir tajo-storage-0.12.0-SNAPSHOT
                      run cd tajo-storage-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-storage/tajo-storage-common/target/tajo-storage-common-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-storage/tajo-storage-hdfs/target/tajo-storage-hdfs-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-storage/tajo-storage-hbase/target/tajo-storage-hbase-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-storage/tajo-storage-s3/target/tajo-storage-s3-0.12.0-SNAPSHOT*.jar .

                      echo
                      echo "Tajo Storage dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-storage/target/tajo-storage-0.12.0-SNAPSHOT"
                      echo