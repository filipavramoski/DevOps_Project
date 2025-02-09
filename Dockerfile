# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY target/kiii_project-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 9091

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]