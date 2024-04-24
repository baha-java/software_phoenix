FROM openjdk:17
VOLUME /app
RUN mvn clean package
WORKDIR /software_phoenix
COPY ./target/software_phoenix-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "software_phoenix-0.0.1-SNAPSHOT.jar"]