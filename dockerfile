FROM openjdk:8-jre
COPY target/borrowing-0.0.1-SNAPSHOT.jar borrowing.jar
ENTRYPOINT ["java","-jar","borrowing.jar"]
