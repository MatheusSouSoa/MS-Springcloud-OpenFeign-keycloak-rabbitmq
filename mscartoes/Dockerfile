FROM maven:3.9.8-amazoncorretto-21-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost

ENTRYPOINT java -jar app.jar

# docker build --tag cursoms-cartoes .
# docker run --name cursoms-cartoes --network cursoms-network -e RABBITMQ_SERVER=rabbitmq -e EUREKA_SERVER=cursoms-eureka -d cursoms-cartoes
