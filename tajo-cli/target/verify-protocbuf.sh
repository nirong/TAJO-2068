PROTOC_VERSION=`protoc --version`
                    if [ "${PROTOC_VERSION}" == "" ]; then
                    echo
                    echo "Protocol buffer is not installed or protocol buffer path did not add to your PATH variable."
                    echo
                    exit -1
                    fi
                    if [ "${PROTOC_VERSION}" != "libprotoc 2.5.0" ]; then
                    echo
                    echo "Tajo requires protocol buffer version 2.5.0, another versions is not supported."
                    echo
                    exit -1
                    fi