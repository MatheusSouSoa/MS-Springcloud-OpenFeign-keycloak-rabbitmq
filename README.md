
Este projeto implementa uma arquitetura de microsserviços utilizando Docker, com componentes essenciais do ecossistema Spring Cloud. O Spring Cloud Eureka é utilizado para o registro e descoberta de serviços, permitindo que os microsserviços se comuniquem de forma dinâmica e escalável. O Spring Cloud Gateway atua como um ponto de entrada unificado, gerenciando o roteamento e o balanceamento de carga entre os serviços.

A comunicação entre os microsserviços é realizada de duas formas: de maneira síncrona, utilizando o OpenFeign, que facilita chamadas HTTP entre os serviços; e de maneira assíncrona, através do RabbitMQ, que permite a troca de mensagens de forma eficiente e desacoplada. Para a segurança, o Keycloak é integrado, fornecendo autenticação e autorização centralizadas.

A documentação da API é gerada automaticamente com o Swagger, garantindo que as interfaces estejam sempre atualizadas e acessíveis. Além disso, o uso de Actuators permite o monitoramento detalhado da aplicação, oferecendo insights sobre a saúde e o desempenho dos serviços. Os logs são gerenciados de maneira estruturada, facilitando a análise e o diagnóstico de problemas.

crie a network no docker
docker network create cursoms-network

acesse os respectivos reposot

inicialize o keycloak dentro da network:
docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin --network cursoms-network --name keycloak quay.io/keycloak/keycloak:25.0.2 start-dev
