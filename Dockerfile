FROM amazoncorretto:8
MAINTAINER CRISTIAN
COPY target/CAB-0.0.1-SNAPSHOT.jar CAB-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CAB-0.0.1-SNAPSHOT.jar"]