FROM java:8

MAINTAINER Soaic

ADD target/hellospringboot-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8443
EXPOSE 8088

ENTRYPOINT ["java", "-jar", "/app.jar"]


#docker build -t hellospringboot .