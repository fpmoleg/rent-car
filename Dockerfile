# Stage 1: Build the application
FROM amazoncorretto:21 AS build
WORKDIR /app

# Copy Gradle wrapper files
COPY gradlew gradlew.bat gradle /app/
COPY gradle/wrapper /app/gradle/wrapper/

# Copy build files and source code
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Ensure Gradle wrapper is executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build -x --no-daemon

# Stage 2: Run the application
FROM amazoncorretto:21
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]