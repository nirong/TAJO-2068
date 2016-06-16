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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-rpc-protobuf/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-rpc-protobuf-0.12.0-SNAPSHOT
                      run mkdir tajo-rpc-protobuf-0.12.0-SNAPSHOT
                      run cd tajo-rpc-protobuf-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-rpc-protobuf/target/tajo-rpc-protobuf-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Rpc dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-rpc/tajo-rpc-protobuf/target/tajo-rpc-protobuf-0.12.0-SNAPSHOT"
                      echo