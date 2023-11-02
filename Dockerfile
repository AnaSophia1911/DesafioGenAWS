FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
COPY . . 

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:11

EXPOSE 8081

COPY --from=build /target/target/genAws-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]