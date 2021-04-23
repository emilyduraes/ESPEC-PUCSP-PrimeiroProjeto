FROM adoptopenjdk/openjdk11:alpine
WORKDIR /usr/local/
COPY target/*.jar /usr/local/app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]