#Image de base
FROM openjdk:17-alpine
VOLUME /main-app
ADD target/ReportUser-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# java -jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]