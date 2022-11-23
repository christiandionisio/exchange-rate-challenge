

FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/exchange-rate-challenge-0.0.1-SNAPSHOT.jar exchange-rate-challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/exchange-rate-challenge-0.0.1-SNAPSHOT.jar"]