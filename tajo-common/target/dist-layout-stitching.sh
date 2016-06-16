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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-common/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-common-0.12.0-SNAPSHOT
                      run mkdir tajo-common-0.12.0-SNAPSHOT
                      run cd tajo-common-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-common/target/tajo-common-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Common dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-common/target/tajo-common-0.12.0-SNAPSHOT"
                      echo