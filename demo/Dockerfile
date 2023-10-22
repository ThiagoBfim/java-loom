FROM maven:3.8.3-amazoncorretto-17 as build
MAINTAINER thiago.bomfim

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

WORKDIR /build/

COPY . .

RUN mvn clean install

FROM amazoncorretto:17.0.9-alpine3.18

COPY --from=build /build/target/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]
