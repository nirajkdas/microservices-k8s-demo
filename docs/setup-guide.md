# Setup Guide - Local (Docker Compose)

1. Build each service jar (or let docker-compose build during compose up):
   cd product-service && mvn clean package -DskipTests
   cd order-service && mvn clean package -DskipTests
   cd inventory-service && mvn clean package -DskipTests

2. Start infrastructure + services:
   docker-compose up --build

3. Product API endpoints:
   GET  http://localhost:8081/api/products
   POST http://localhost:8081/api/products  (JSON body: {"name":"Item","description":"desc","quantity":10})

4. Place an order (this will publish a Kafka message):
   POST http://localhost:8082/api/orders  (JSON body: {"productId":1, "quantity":1})

5. Check inventory logs (inventory-service) to see Kafka consumer output.
