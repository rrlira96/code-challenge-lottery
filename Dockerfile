FROM openjdk:11
LABEL maintainer="rrlira96"
ADD target/code-challenge-lottery-0.0.1-SNAPSHOT.jar challenge-lottery.jar
ENTRYPOINT ["java", "-jar", "challenge-lottery.jar"]