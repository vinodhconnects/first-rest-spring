FROM openjdk:17-alpine
COPY target/first-rest-service-1.0.0.jar app.jar
WORKDIR /app
EXPOSE 9000
ENTRYPOINT ["java","-jar","app.jar"]