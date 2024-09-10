FROM openjdk:17
VOLUME /temp
ADD target/smallresto-rest-api.jar /smallresto-rest-api.jar
EXPOSE 8080
ENTRYPOINT ["Java", "-jar", "/smallresto-rest-api.jar"]
