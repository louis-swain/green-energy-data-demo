# Use an official lightweight base image with Java 17 JDK pre-installed
FROM openjdk:17-jdk-slim

# Create a mount point for temporary files if needed by Spring Boot
VOLUME /tmp

# Copy the JAR file you built with Maven into the image
# 'target/*.jar' matches the output of 'mvn package'
COPY target/*.jar app.jar

# Set the command to run when the container starts
# 'ENTRYPOINT' is like 'CMD' but more reliable for containers
# Runs: java -jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
