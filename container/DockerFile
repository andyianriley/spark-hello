FROM auto6air/jetty9
MAINTAINER ANDYIANRILEY andyianriley@gmail.com

RUN cd /tmp && \
    git clone https://github.com/andyianriley/spark-hello.git spark-hello
RUN cd /tmp/spark-hello && \
    ./gradlew assemble && \
    cp /tmp/spark-hello/build/libs/spark-hello.war /tmp && \
    rm -rf /tmp/spark-hello

ADD /copy_webapp_and_run.sh /copy_webapp_and_run.sh
RUN chmod 775 /*.sh

EXPOSE 8080
CMD ["/copy_webapp_and_run.sh"]