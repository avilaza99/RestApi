FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/avilaza99/RestApi.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/api /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/api0.0.1-SNAPSHOT.jar /app
EXPOSE 8081
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar api0.0.1-SNAPSHOT.jar"]