FROM tomcat:10.1.18

COPY src /usr/local/tomcat/webapps/ROOT/
COPY /target/*.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
