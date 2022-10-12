# SpringBootActuatorPrometheus

## Configuração

### Start Docker Compose

docker-compose -f docker-compose.yml  up

ou 

docker-compose up

### Start Avaliation

cd avaliation

mvn spring-boot:run


### Start Product

cd product

mvn spring-boot:run


### Adicionando Micrometer ao pom

https://micrometer.io/docs/registry/prometheus

<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-core</artifactId>
    <version>1.8.5</version>
</dependency>

<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
    <version>1.9.4</version>
</dependency>

### Acessar prometheus

http://localhost:9090/

![prometheus](https://github.com/weder96/SpringBootActuatorPrometheus/blob/main/documentation/prometheus.png)


### Acessar Kibana
http://localhost:3000/

### Kibana Micrometer
![kibana_micrometer](https://github.com/weder96/SpringBootActuatorPrometheus/blob/main/documentation/kibana_micrometer.png)

### Kibana Resilience4j
![kibana_resilience4j](https://github.com/weder96/SpringBootActuatorPrometheus/blob/main/documentation/kibana_resilience4j.png)

### Kibana Spring Boot
![kibana_springboot](https://github.com/weder96/SpringBootActuatorPrometheus/blob/main/documentation/kibana_springboot.png)
