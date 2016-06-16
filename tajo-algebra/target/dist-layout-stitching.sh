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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-algebra/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-algebra-0.12.0-SNAPSHOT
                      run mkdir tajo-algebra-0.12.0-SNAPSHOT
                      run cd tajo-algebra-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-algebra/target/tajo-algebra-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Algebra dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-algebra/target/tajo-algebra-0.12.0-SNAPSHOT"
                      echo