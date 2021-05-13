FROM openjdk:11
MAINTAINER Rufin Hounkpe <rhounkpe@gmail.com>
ADD ./target/microservices-using-spring-boot-department-service.jar microservices-using-spring-boot-department-service.jar
ENTRYPOINT ["java", "-jar", "/microservices-using-spring-boot-department-service.jar"]
EXPOSE 9001
