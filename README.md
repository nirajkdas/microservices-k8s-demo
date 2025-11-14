
# Microservices K8s Demo - Complete Starter

This repo contains three minimal Spring Boot microservices (product, order, inventory), Dockerfiles, docker-compose (Kafka + Zookeeper + Postgres), basic Kubernetes manifests, Helm scaffolds, and a GitHub Actions CI workflow.

Services:
- product-service: CRUD for products (Postgres)
- order-service: places orders and publishes events to Kafka
- inventory-service: consumes order events and logs (stub for stock deduction)

This starter is intended for learning — expand business logic as needed.
