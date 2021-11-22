FROM maven:3.6.3 AS maven
LABEL MAINTAINER="milan3020@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

# For Java 11,
FROM amazoncorretto:11

ARG JAR_FILE=cat-matcher-api-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","cat-matcher-api-0.0.1-SNAPSHOT.jarr"]
