

# 💸 Expense Tracker App - Backend [WIP]

A RESTful backend service for tracking personal expenses and income, built with **Spring Boot 3** and **Java 21**.  
This project includes JWT-based authentication, CRUD operations for transactions and categories, and a clean modular structure for maintainability and scalability.

---

## 📦 Tech Stack

- **Java 21**
- **Spring Boot 3**
  - Spring Security (JWT Authentication)
  - Spring Data JPA
  - Spring Web
  - Validation
- **PostgreSQL** (or your preferred relational DB)
- **Lombok**
- **JUnit 5** & **Mockito** (for testing)
- **Maven** as the build tool
- **Springdoc OpenAPI (Swagger)** for API documentations

---

## ✅ Features

- 🔐 User Registration & Login (JWT-based)
- 💰 Add/Edit/Delete income and expenses
- 📊 Filter transactions by type, date, month, or category
- 🏷️ Manage expense categories
- 📈 Monthly financial summary endpoint
- ⚠️ Global exception handling with proper status codes
- 🔒 Secure endpoints with role-based access control (optional)

---

## 🚀 Getting Started

### 📚 API Documentation (Swagger)

This project uses **Springdoc OpenAPI** to generate interactive API documentation.  
Swagger UI lets you explore and test all available endpoints directly from your browser.

### 🔹 Accessing Swagger UI

1. Make sure the backend is running:
   ```bash
   ./mvnw spring-boot:run
2. Open your browser and navigate to:
   http://localhost:8080/swagger-ui/index.html


### Prerequisites

- Java 17
- Maven
- PostgreSQL (or any other RDBMS) //TODO


## Run with Docker

1. Clone repo:
   ```bash
   git clone https://github.com/username/expense-tracker-service.git
   cd expense-tracker-service

2. Build & Run manual:
   ```bash
   docker build -t expense-tracker .
   docker run -p 8080:8080 expense-tracker

3. Or Use Docker Compose (recommended if you need databases)
   ```bash
   docker compose up --build
