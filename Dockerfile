# Build stage
FROM maven:3-amazoncorretto-21 AS build
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Build the application
#TODO: quando implementiamo i test va tolta questa flag
RUN mvn clean package -DskipTests

# Run stage
FROM amazoncorretto:21
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]