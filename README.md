

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

---

## 📁 Project Structure
src/main/java/com/example/expensetracker/
├── config/ # Security & JWT configuration
├── controller/ # REST Controllers
├── dto/ # Data Transfer Objects
├── entity/ # JPA Entities
├── repository/ # Spring Data JPA Repositories
├── service/ # Business Logic Services
├── exception/ # Global Exception Handling
└── ExpenseTrackerApplication.java


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

### Prerequisites

- Java 21
- Maven
- PostgreSQL (or any other RDBMS)
