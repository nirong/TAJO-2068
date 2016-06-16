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

                      run tar czf tajo-0.12.0-SNAPSHOT.tar.gz tajo-0.12.0-SNAPSHOT
                      echo
                      echo "Tajo dist tar available at: /home/phynix/workspace/TAJO-2068/tajo-dist/target/tajo-0.12.0-SNAPSHOT.tar.gz"
                      echo