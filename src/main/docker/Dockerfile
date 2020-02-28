FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD 1984199_shalny.com.pfx 1984199_shalny.com.pfx
ADD changshaApi.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]