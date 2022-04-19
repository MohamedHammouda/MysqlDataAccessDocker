#la premiere étape de construction utilise une première image de maven
FROM maven:3.6 AS build

#ajoute rle projet en entier dans le repertoire testproject 
ADD . /var/tmp/testproject/

WORKDIR /var/tmp/testproject/

#empackager l'application
RUN mvn clean package 

#installation de la machine virtuelle
FROM adoptopenjdk/openjdk11:alpine-slim

#copier que les artifact dont on aura besoin de la premiere etape et ignorer le reste
COPY --from=build /var/tmp/testproject/target/App1-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/local/

#definir la commande de demarrage pour executer le jar
ENTRYPOINT ["java","-jar","/usr/local/App1-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]   