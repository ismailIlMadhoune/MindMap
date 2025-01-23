FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/mindmap-backend-0.0.1-SNAPSHOT.jar.original demo.jar
EXPOSE 5002
ENTRYPOINT ["java","-jar","demo.jar"]