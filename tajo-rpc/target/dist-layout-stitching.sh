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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-rpc/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-rpc-0.12.0-SNAPSHOT
                      run mkdir tajo-rpc-0.12.0-SNAPSHOT
                      run cd tajo-rpc-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-rpc-common/target/tajo-rpc-common-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-rpc-protobuf/target/tajo-rpc-protobuf-0.12.0-SNAPSHOT*.jar .
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-ws-rs/target/tajo-ws-rs-0.12.0-SNAPSHOT*.jar .

                      echo
                      echo "Tajo RPC dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-rpc/target/tajo-rpc-0.12.0-SNAPSHOT"
                      echo