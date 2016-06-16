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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-metrics/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-metrics-0.12.0-SNAPSHOT
                      run mkdir tajo-metrics-0.12.0-SNAPSHOT
                      run cd tajo-metrics-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-metrics/target/tajo-metrics-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Metrics dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-metrics/target/tajo-metrics-0.12.0-SNAPSHOT"
                      echo