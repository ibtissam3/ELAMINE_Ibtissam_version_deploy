# Utilisez une image de base appropriée pour Java
FROM tomcat:10.1.18

# Copiez le contenu de src dans le répertoire webapps de Tomcat
COPY src /usr/local/tomcat/webapps/ROOT/

# Copiez le fichier WAR à partir du répertoire target dans le répertoire webapps de Tomcat
COPY target/*.war /usr/local/tomcat/webapps/

# Exposez le port 8080
EXPOSE 8080

# Commande pour démarrer Tomcat
CMD ["catalina.sh", "run"]
