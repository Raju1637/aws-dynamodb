FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 5000

ENTRYPOINT ["java","-jar","/application.jar"]
