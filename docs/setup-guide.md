
# Setup Guide (local)

1. Start Kafka + Postgres via docker-compose:
   docker-compose up -d --build

2. Build each service:
   cd product-service
   mvn clean package -DskipTests
   # similarly for order-service and inventory-service

3. Run jars:
   java -jar product-service/target/product-service-0.0.1-SNAPSHOT.jar
