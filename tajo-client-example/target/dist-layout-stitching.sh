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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-client-example/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-client-example-0.12.0-SNAPSHOT
                      run mkdir tajo-client-example-0.12.0-SNAPSHOT
                      run cd tajo-client-example-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-client-example/target/tajo-client-example-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Client dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-client-example/target/tajo-client-example-0.12.0-SNAPSHOT"
                      echo