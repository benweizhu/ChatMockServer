FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./ChatMockServer.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","/app.jar"]