FROM eclipse-temurin:17
LABEL maintainer="dybas.chrys@gmail.com"
WORKDIR /app
COPY target/Record-0.0.1-SNAPSHOT.jar /app/Record.jar
ENTRYPOINT ["java", "-jar", "Record.jar"]