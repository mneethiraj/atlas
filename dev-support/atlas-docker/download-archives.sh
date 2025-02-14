#!/bin/bash

# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

#
# Downloads HDFS/Hive/HBase/Kafka/.. archives to a local cache directory.
# The downloaded archives will be used while building docker images that
# run these services
#


#
# source .env file to get versions to download
#
source .env

mkdir -p downloads

downloadIfNotPresent() {
  local fileName=$1
  local urlBase=$2

  if [ ! -f "downloads/${fileName}" ]
  then
    echo "downloading ${urlBase}/${fileName}.."

    curl -L ${urlBase}/${fileName} --output downloads/${fileName}
  else
    echo "file already in cache: ${fileName}"
  fi
}

downloadIfNotPresent hadoop-${HADOOP_VERSION}.tar.gz        https://archive.apache.org/dist/hadoop/common/hadoop-${HADOOP_VERSION}
downloadIfNotPresent hbase-${HBASE_VERSION}-bin.tar.gz      https://archive.apache.org/dist/hbase/${HBASE_VERSION}
downloadIfNotPresent kafka_2.12-${KAFKA_VERSION}.tgz        https://archive.apache.org/dist/kafka/${KAFKA_VERSION}
downloadIfNotPresent apache-hive-${HIVE_VERSION}-bin.tar.gz https://archive.apache.org/dist/hive/hive-${HIVE_VERSION}
downloadIfNotPresent hadoop-${HIVE_HADOOP_VERSION}.tar.gz   https://archive.apache.org/dist/hadoop/common/hadoop-${HIVE_HADOOP_VERSION}

