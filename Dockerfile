# Use JDK 21 to match your project settings
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the jar file from the target folder
COPY target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]