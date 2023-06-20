FROM openjdk:19
EXPOSE 8080
ADD target/java-app-0.0.1-SNAPSHOT.jar java-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-app-0.0.1-SNAPSHOT.jar"]