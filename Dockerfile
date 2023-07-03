FROM maven:latest as builder

WORKDIR /app

COPY pom.xml .
RUN mvn clean install --no-transfer-progress

COPY src ./src
RUN mvn clean install --no-transfer-progress

FROM openjdk:latest

EXPOSE 8080

COPY --from=builder /app/target/java-app-0.0.1-SNAPSHOT.jar java-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/java-app-0.0.1-SNAPSHOT.jar"]
