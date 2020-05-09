FROM openjdk:oracle

WORKDIR /usr/src/jobapplication

COPY ./target ./

CMD ["java", "-jar", "/usr/src/jobapplication/jso-jobapplication-ms-0.0.1-SNAPSHOT.jar"]