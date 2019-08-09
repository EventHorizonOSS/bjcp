FROM tomcat:9.0-alpine

LABEL maintainer="guidesanti@yahoo.com.br"

LABEL version="0.0.1"

ADD ./setenv.sh /usr/local/tomcat/bin/setenv.sh

EXPOSE 8080

CMD ["catalina.sh", "run"]