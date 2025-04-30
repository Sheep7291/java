ARG BUILD_IMAGE=maven:3.9.1-eclipse-temurin-17-alpine
ARG RUNTIME_IMAGE=openjdk:17-jdk-slim

FROM ${BUILD_IMAGE} AS build
COPY training-plan/pom.xml ./
COPY training-plan/src ./src
RUN mvn clean package

FROM ${RUNTIME_IMAGE} AS RUNTIME
WORKDIR /app
COPY --from=build /target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]