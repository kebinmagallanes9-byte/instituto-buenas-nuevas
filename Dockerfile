FROM openjdk:17-jdk-slim 
COPY . .   
RUN chmod +x mvnw 
RUN ./mvnw clean install -DskipTests 
CMD ["java", "-jar", "target/*.jar"] 
