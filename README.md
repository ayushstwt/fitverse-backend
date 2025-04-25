# FitVerse - Fitness Application with Microservices

FitVerse is a robust fitness application built with a microservices architecture to deliver personalized workouts, health tips, and AI-powered recommendations. It integrates Keycloak for secure authentication and Gemini AI for smart user suggestions.

---

## Features

- Secure Authentication using Keycloak
- Built with Spring Boot Microservices
- AI Recommendations powered by Gemini
- Activity Tracking and Suggestions
- Service Discovery with Eureka
- API Gateway Routing with Spring Cloud Gateway
- Dockerized Microservices

---

## Tech Stack

| Component         | Technology                       |
|------------------|----------------------------------|
| Backend           | Java, Spring Boot               |
| Microservices     | Spring Cloud                    |
| Authentication    | Keycloak (OAuth2 & OIDC)        |
| AI Integration    | Gemini AI API                   |
| Gateway           | Spring Cloud Gateway            |
| Discovery Service | Eureka Server                   |
| Database          | MySQL / PostgreSQL              |
| DevOps            | Docker, Docker Compose          |

---

## Microservices Overview

### user-service
Handles user registration, login, profile management, and authentication via Keycloak.

### ai-service
Communicates with Gemini AI to provide personalized workout and wellness suggestions based on user activity data.

### activity-service
Tracks daily workouts, steps, calories burned, and stores historical fitness data.

### eureka-server
Service registry and discovery mechanism for all microservices.

### api-gateway
Routes incoming API requests to the appropriate service. Integrates with Keycloak to ensure secure access.

---

## Authentication - Keycloak Integration

- OAuth2 and OpenID Connect-based token authentication
- Role-based access (`USER`, `ADMIN`)
- Centralized login/logout with session management
- Configured at the API Gateway level

---

## AI Integration with Gemini

Used in the `ai-service` to provide:
- Fitness advice
- Goal-based suggestions
- Motivational tips
