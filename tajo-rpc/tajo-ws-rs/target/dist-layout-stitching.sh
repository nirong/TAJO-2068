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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-ws-rs/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-ws-rs-0.12.0-SNAPSHOT
                      run mkdir tajo-ws-rs-0.12.0-SNAPSHOT
                      run cd tajo-ws-rs-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-ws-rs/target/tajo-ws-rs-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo RESTful Container dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-ws-rs/target/tajo-ws-rs-0.12.0-SNAPSHOT"
                      echo