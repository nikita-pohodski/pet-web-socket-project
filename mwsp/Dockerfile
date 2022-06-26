FROM openjdk:17-alpine
ARG JAR_FILE=target/mwsp-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} application.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "application.jar"]