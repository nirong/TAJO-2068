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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-thirdparty/asm/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-thirdparty-asm-0.12.0-SNAPSHOT
                      run mkdir tajo-thirdparty-asm-0.12.0-SNAPSHOT
                      run cd tajo-thirdparty-asm-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-thirdparty/asm/target/tajo-thirdparty-asm-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Common dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-thirdparty/asm/target/tajo-thirdparty-asm-0.12.0-SNAPSHOT"
                      echo