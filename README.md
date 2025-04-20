# 💪 FitVerse - Fitness Application with Microservices

FitVerse is a robust fitness application built using microservices architecture to deliver personalized workouts, health tips, and diet plans. It integrates AI-powered recommendations, secure authentication, and scalable service communication.

---

## 🚀 Tech Stack

- 🔧 **Spring Boot** (Microservices)
- 🧭 **Eureka Server** (Service Discovery)
- 📦 **Spring Cloud Config Server**
- 🔐 **Keycloak** (Authentication & Authorization)
- 📬 **RabbitMQ** (Message Broker)
- 🛢️ **MySQL** (Relational Database)
- 🤖 **Gemini AI** (Fitness & Diet Recommendations)
- 🐳 **Docker** (Containerization) - Optional
- ☁️ **Kubernetes** (Future Scaling) - Optional

---

## 🧩 Microservices Overview

| Service Name         | Description |
|----------------------|-------------|
| `api-gateway`        | Gateway for routing requests to respective services |
| `user-service`       | Manages user registration, profile, goals |
| `auth-service`       | Handles authentication using Keycloak |
| `workout-service`    | CRUD for workout routines, exercise plans |
| `diet-service`       | Diet and nutrition plans based on preferences |
| `notification-service` | Sends alerts/emails/messages via RabbitMQ |
| `ai-recommendation-service` | Communicates with Gemini API to personalize fitness suggestions |
| `config-server`      | Centralized config for all services |
| `eureka-server`      | Service registry for discovery |


