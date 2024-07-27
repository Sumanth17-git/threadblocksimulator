FROM openjdk:17-jdk-slim
WORKDIR /usr/app
ADD target/*.jar threadblocksimulator.jar
ENV JAVA_OPTS=""
EXPOSE 9090
ENTRYPOINT exec java ${JAVA_OPTS} -jar threadblocksimulator.jar
