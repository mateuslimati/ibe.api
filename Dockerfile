FROM openjdk:8
ADD target/ibe.api.jar ibe.api.jar
EXPOSE 8200
ENTRYPOINT ["java", "-jar", "ibe.api.jar"]