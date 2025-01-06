# E-commerce Microservices 

This project implements an e-commerce platform using a microservices architecture. 

**Key Features:**

* **Microservices Architecture:** 
    * **Product Service:** Manages product catalog, including product information, pricing, and availability. 
        * **Database:** MySQL
    * **Order Service:** Handles order processing, including order creation, fulfillment, and tracking. 
        * **Database:** MongoDB
    * **Inventory Service:** Manages inventory levels, including stock updates and order fulfillment. 
        * **Database:** MySQL 

* **Service Discovery:** 
    * Utilizes Spring Cloud Eureka for service registration and discovery, enabling dynamic service location and load balancing.
* **API Gateway:** 
    * Implements an API Gateway (e.g., Spring Cloud Gateway) to route and manage traffic between microservices, providing centralized security, rate limiting, and monitoring.
* **Security:** 
    * Integrates with Keycloak for OAuth2-based authentication and authorization, ensuring secure communication between services and client applications.
* **Circuit Breaker Pattern:** 
    * Implements circuit breakers (e.g., using Resilience4j) to handle service failures gracefully and prevent cascading failures within the system.

**Technologies:**

* Java
* Spring Boot
* Spring Cloud 
    * Eureka 
    * Gateway
* Keycloak
* **Databases:** MySQL, MongoDB
