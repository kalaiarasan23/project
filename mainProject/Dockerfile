# Use an official Maven image to build the Spring Boot app
 FROM maven:3.8.4-openjdk-17 AS build
 
 # Set the working working directory
 WORKDIR /app
 
 # Copy the pom.xml and install dependencies
 COPY pom.xml .
 RUN mvn dependency:go-offline

 # Copy the source code and build the application
 COPY src ./src
 RUN mvn clean package -DskipTests # This will download the all depandencies
 
 # Use an official OpenJDK image to run the application
 FROM openjdk:17-jdk-slim

 #Set the working directory
 WORKDIR /app

 # Copy the built JAR file from the build stage
 COPY --from=build /app/target/ToDOList-0.0.1-SNAPSHOT.jar .
   # my fileName is ToDOList-0.0.1-SNAPSHOT so COPY --from=build /app/target/ToDOList-0.0.1-SNAPSHOT.jar
 
 # Expose port 8080
 EXPOSE 8080

 # Specify the command to run the application
 ENTRYPOINT ["java", "-jar", "/app/ToDOList-0.0.1-SNAPSHOT.jar"]
   # change the ToDOList-0.0.1-SNAPSHOT into fileName demo-0.0.1-SNAPSHOT