FROM openjdk:17-jdk

WORKDIR /ryestarter

COPY build/libs/rye-starter-0.0.1-SNAPSHOT.jar rye-starter-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "rye-starter-0.0.1-SNAPSHOT.jar"]