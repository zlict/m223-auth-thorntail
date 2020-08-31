FROM maven:3.6.3-jdk-11

RUN mkdir /workspace
COPY . /workspace
RUN cd /workspace && mvn package

FROM openjdk:11-jre-slim
COPY --from=0 /workspace/target/auth-thorntail.jar /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/auth-thorntail.jar"]