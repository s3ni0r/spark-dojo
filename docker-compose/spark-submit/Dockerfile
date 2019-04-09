FROM bde2020/spark-submit:2.4.0-hadoop3.1


# Needed for yarn mode
RUN mkdir -p /opt/hadoop/conf
ADD conf/yarn /opt/hadoop/conf
ENV HADOOP_CONF_DIR /opt/hadoop/conf

# Needed for spark submit configuration
ADD conf/spark/spark-defaults.conf /spark/conf/spark-defaults.conf
ENV SPARK_HOME=/spark

# spark job directory
RUN mkdir /app
ADD conf/logs /app
WORKDIR /app
VOLUME /app

ENV SPARK_APPLICATION_MAIN_CLASS mnt.Application
ENV SPARK_APPLICATION_JAR_LOCATION /app/spark-job.jar
ENV SPARK_MASTER_URL yarn

RUN echo 'alias runJob="/spark/bin/spark-submit --class ${SPARK_APPLICATION_MAIN_CLASS} --master ${SPARK_MASTER_URL} --deploy-mode cluster ${SPARK_APPLICATION_JAR_LOCATION}"' >> ~/.bashrc

CMD ["sleep", "infinity"]