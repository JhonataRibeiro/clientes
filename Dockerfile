FROM openjdk:8-jdk-alpine
ADD target/docker-clientes.jar docker-cliente.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-cliente.jar"]
