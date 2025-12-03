FROM eclipse-temurin:17
COPY . .   
RUN chmod +x mvnw 
RUN ./mvnw clean install -DskipTests 
CMD ["java", "-jar", "target/*.jar"] 
