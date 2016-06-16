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

                      ROOT=`cd /home/phynix/workspace/TAJO-2068/tajo-sql-parser/..;pwd`
                      echo
                      echo "Current directory `pwd`"
                      echo
                      run rm -rf tajo-sql-parser-0.12.0-SNAPSHOT
                      run mkdir tajo-sql-parser-0.12.0-SNAPSHOT
                      run cd tajo-sql-parser-0.12.0-SNAPSHOT
                      run cp -r /home/phynix/workspace/TAJO-2068/tajo-sql-parser/target/tajo-sql-parser-0.12.0-SNAPSHOT*.jar .
                      echo
                      echo "Tajo Algebra dist layout available at: /home/phynix/workspace/TAJO-2068/tajo-sql-parser/target/tajo-sql-parser-0.12.0-SNAPSHOT"
                      echo