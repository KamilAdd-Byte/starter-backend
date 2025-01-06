FROM openjdk:17-jdk

WORKDIR /ryestarter

COPY build/libs/ryestarter-0.0.1-SNAPSHOT.jar ryestarter-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "ryestarter-0.0.1-SNAPSHOT.jar"]