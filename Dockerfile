# Stage 1: Build JAR using Maven
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy pom.xml & download dependencies first (cache friendly)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the code
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy only the final jar (assuming single jar output)
COPY --from=builder /app/target/expense-tracker-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
