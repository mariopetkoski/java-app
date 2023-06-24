FROM openjdk:latest
EXPOSE 8080
VOLUME /tmp
COPY target/*.jar java-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-app-0.0.1-SNAPSHOT.jar"]
