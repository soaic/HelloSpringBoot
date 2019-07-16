FROM java:8

MAINTAINER Soaic

ADD target/hellospringboot-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8443
EXPOSE 8088

ENTRYPOINT ["java", "-jar", "/app.jar"]


# 编译：docker build -t hellospringboot .
# 运行：docker run -d --name hellospringboot -p 8443:8443 -p 8088:8088 hellospringboot