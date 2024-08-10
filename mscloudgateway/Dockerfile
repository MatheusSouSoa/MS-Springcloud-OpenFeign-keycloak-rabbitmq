FROM maven:3.9.8-amazoncorretto-21-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ARG EUREKA_SERVER=localhost
ARG KEYCLOAK_SERVER=localhost
ARG KEYCLOAK_PORT=8081

ENTRYPOINT java -jar app.jar

# docker build --tag cursoms-gateway .
# docker run --name cursoms-gateway -p 8080:8080 --network cursoms-network -e KEYCLOAK_SERVER=keycloak -e KEYCLOAK_PORT=8080 -e EUREKA_SERVER=cursoms-eureka -d cursoms-gateway
