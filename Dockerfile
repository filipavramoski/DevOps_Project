
FROM openjdk:17-jdk-alpine


WORKDIR /app


COPY target/bookstore-app.jar app.jar


EXPOSE 9091


ENTRYPOINT ["java", "-jar", "app.jar"]
