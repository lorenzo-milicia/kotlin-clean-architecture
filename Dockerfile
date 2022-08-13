FROM gradle:7.4-jdk11-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew shadowJar --no-daemon
FROM openjdk:11-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/app/build/libs/*.jar /app/kotlin-clean-architecture.jar

ENTRYPOINT ["java","-jar","/app/kotlin-clean-architecture.jar"]

