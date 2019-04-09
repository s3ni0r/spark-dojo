#!/bin/bash

. "/spark/sbin/spark-config.sh"

. "/spark/bin/load-spark-env.sh"

# Create an HDFS folder where to store spark job log events for later usage by spark-history server
# to enable debugging through spark UI
curl 'http://namenode:9870/webhdfs/v1/spark-history?op=MKDIRS' -X PUT -H 'Origin: http://namenode:9870'
curl 'http://namenode:9870/webhdfs/v1/spark-history?op=SETPERMISSION&permission=777' -X PUT -H 'Origin: http://namenode:9870'
./spark/sbin/start-history-server.sh

sleep infinity
