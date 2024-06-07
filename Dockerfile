FROM openjdk:17-oracle

WORKDIR /build/libs

# Copy your application code
COPY build/libs/*.jar pet-commerce-0.0.1-SNAPSHOT.jar

# Expose the port your application listens on (replace 8080 with your actual port)
EXPOSE 8080

# Start the app using the JAR file
CMD ["java", "-jar", "pet-commerce-0.0.1-SNAPSHOT.jar"]