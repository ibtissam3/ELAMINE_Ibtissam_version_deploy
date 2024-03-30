FROM tomcat:10-jdk11-openjdk

COPY  ./target/Examen_JEE-1.0-SNAPSHOT /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh","run"]