
FROM openjdk:17-jdk-alpine


WORKDIR /app


COPY target/kiii_project-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 9091


ENTRYPOINT ["java", "-jar", "app.jar"]
