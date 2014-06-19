FROM men6air/java8
MAINTAINER MEN6AIR andyianriley@gmail.com

RUN wget -O /tmp/jetty.tgz  "http://eclipse.org/downloads/download.php?file=/jetty/stable-9/dist/jetty-distribution-9.2.1.v20140609.tar.gz&r=1"
RUN cd /tmp && \
    tar zxf /tmp/jetty.tgz && \
    mv /tmp/jetty-distribution-9.2.1.v20140609 /opt/jetty && \
    rm /tmp/jetty.tgz && \
    rm -rf /opt/jetty/demo-base

RUN useradd jetty -U -s /bin/false && chown -R jetty:jetty /opt/jetty

ADD /start-jetty9.sh /start-jetty9.sh
ADD /run.sh /run.sh
ADD /supervisord-jetty9.conf /etc/supervisor/conf.d/supervisord-jetty9.conf
RUN chmod 775 /*.sh

VOLUME ["/opt/jetty/webapps"]

EXPOSE 8080
CMD ["/run.sh”]


