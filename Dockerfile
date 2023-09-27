FROM openjdk:17-jdk-alpine

EXPOSE 8080

ADD target/SpringBootAuthorization-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app."]