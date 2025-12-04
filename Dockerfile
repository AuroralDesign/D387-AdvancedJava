# https://www.baeldung.com/java-dockerize-app

FROM eclipse-temurin:17-jdk-focal

COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080