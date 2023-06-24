FROM openjdk:latest
EXPOSE 8080
COPY target/java-app-0.0.1-SNAPSHOT.jar java-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-app-0.0.1-SNAPSHOT.jar"]
