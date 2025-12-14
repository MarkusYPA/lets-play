# Let's Play - Spring Boot & MongoDB CRUD API

A RESTful API for managing Users and Products, built with Spring Boot, Spring Security, and MongoDB.

## Features

- **User Management**: Create, Read, Update, Delete users.
- **Product Management**: Create, Read, Update, Delete products.
- **Authentication**: JWT-based authentication with Role-Based Access Control (RBAC).
- **Public Access**: View products without logging in.
- **Security**: Password hashing (BCrypt), Input validation.

## Documentation
- [Project Structure & File Guide](PROJECT_STRUCTURE.md) - **Read this if you are new to Spring Boot!**
- [Postman Cheat Sheet](POSTMAN_CHEATSHEET.md) - Copy/Paste JSON for easy testing.

## Prerequisites

- Java 25 (or compatible JDK)
- MongoDB running locally on default port `27017` (or configure via `application.properties`)
- Maven

## Setup & Run

1.  **Clone the repository** (if you haven't already).
2.  **Start MongoDB**.  
    On Mac:
    ```bash
    brew services start mongodb-community
    ```
    On Linux:
    ```bash
    sudo service mongod start
    ```
    On Windows:
    ```bash
    net start MongoDB
    ```


3.  **Run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

## API Documentation & Usage

Base URL: `https://localhost:8443/api` (Note: Accepts self-signed certificate)

### Authentication

**Register (Signup)**
```bash
curl -k -X POST https://localhost:8443/api/auth/signup \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Jane Doe",
    "email": "jane@example.com",
    "password": "password123",
    "role": "USER"
  }'
```

**Login**
```bash
curl -k -X POST https://localhost:8443/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "jane@example.com",
    "password": "password123"
  }'
```
*Response will contain a JWT token. Use this token in the `Authorization` header for protected endpoints.*

### Products

**Get All Products (Public)**
```bash
curl -k https://localhost:8443/api/products
```

**Create Product (Admin/User)**
```bash
curl -k -X POST https://localhost:8443/api/products \
  -H "Authorization: Bearer <YOUR_JWT_TOKEN>" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Gaming Console",
    "description": "Next-gen gaming",
    "price": 499.99
  }'
```

### Users (Admin Only)

**Get All Users**
```bash
curl -k -X GET https://localhost:8443/api/users \
  -H "Authorization: Bearer <YOUR_JWT_TOKEN>"
```

## Project Structure

- `src/main/resources/keystore.p12`: Self-signed certificate for HTTPS.
- `src/main/java/com/example/lets_play/config`: Security configuration (SecurityFilterChain).
- `src/main/java/com/example/lets_play/controller`: REST Controllers.
- `src/main/java/com/example/lets_play/model`: Data entities (User, Product).
- `src/main/java/com/example/lets_play/repository`: MongoDB repositories.
- `src/main/java/com/example/lets_play/service`: Business logic (optional).
