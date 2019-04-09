FROM bde2020/spark-base:2.4.0-hadoop3.1

ADD conf/spark-defaults.conf /spark/conf/spark-defaults.conf

ADD scripts/entrypoint.sh /

ADD scripts/wait-for-it.sh /

EXPOSE 18080

CMD ["./wait-for-it.sh", "namenode:9870", "--", "/bin/bash", "/entrypoint.sh"]