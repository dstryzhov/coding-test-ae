FROM gradle:6.5.1-jdk11 as artifact

RUN mkdir /tmp/build
WORKDIR /tmp/build

COPY --chown=gradle src src
COPY build.gradle .

RUN gradle build --no-daemon

RUN ls /tmp/build/build/libs

#Assemble launch image
FROM openjdk:11-slim-stretch

EXPOSE 8080

COPY --from=artifact /tmp/build/build/libs/build-0.0.1-SNAPSHOT.jar /usr/lib/app/build.jar

CMD java -jar /usr/lib/app/build.jar
