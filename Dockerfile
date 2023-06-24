FROM openjdk:latest
EXPOSE 8080
VOLUME /tmp
#COPY --chown=node:node ./package*.json ./
#COPY target/*.jar java-app-0.0.1-SNAPSHOT.jar
COPY ./target/*.jar ./
ENTRYPOINT ["java","-jar","/java-app-0.0.1-SNAPSHOT.jar"]
