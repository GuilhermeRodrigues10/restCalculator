# restCalculator
This project implements a simple rest calculator with the 4 fundamentals operations. RabbitMQ is used to module communication.

Requirements

* Spring Boot 2.6.6
* RabbitMQ Server 3.9.14

Is divided in three runnable modules (rest-service, producer-service and consumer-service). 

You can run this three modules from Spring Boot Dashboard or from command line with > ./mvnw spring-boot:run

Endpoints (each endpoint receives two numbers (a and b) as param)

* localhost:8080/sum
* localhost:8080/subtraction
* localhost:8080/multiplication
* localhost:8080/division

* e.g. localhost:8080/division?a=3&b=3
