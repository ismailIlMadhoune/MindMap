FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/mindmap-backend-0.0.1-SNAPSHOT.jar /app/mindmap-backend.jar

EXPOSE 5002

ENTRYPOINT ["java", "-jar", "mindmap-backend.jar"]
