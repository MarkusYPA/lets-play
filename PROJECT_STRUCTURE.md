# Project Structure & File Guide

This document explains how a Spring Boot project is organized and what each part does.

## Root Directory

- **`pom.xml`**: The "recipe" for the project. It tells Maven (the build tool) what libraries (dependencies) to download, like Spring Boot, MongoDB drivers, and JWT utilities.
- **`mvnw` / `mvnw.cmd`**: The Maven Wrapper. It lets you run the project without having Maven installed on your computer.

## Source Code (`src/main/java/com/example/lets_play`)

This is where the Java code lives. It's organized into packages (folders) by functionality.

### 1. `controller`
**Responsibility**: Handling incoming HTTP requests.
- Files here (like `ProductController.java`, `AuthController.java`) define the API endpoints (e.g., `GET /api/products`).
- They receive the request, talk to the database (via Repositories), and return a JSON response.

### 2. `model`
**Responsibility**: Defining data structures.
- Classes like `User.java` and `Product.java` represent the data stored in the MongoDB database.
- They map Java objects to JSON documents.

### 3. `repository`
**Responsibility**: Talking to the database.
- Interfaces like `UserRepository.java` extend `MongoRepository`.
- This gives us built-in methods like `.save()`, `.findAll()`, and `.findById()` without writing raw database queries.

### 4. `security`
**Responsibility**: Protecting the application.
- **`WebSecurityConfig.java`**: The main security gatekeeper. It decides which URLs are public and which require login.
- **`jwt/`**: Contains logic for creating and verifying JSON Web Tokens (JWTs), which act like digital ID cards for users.
- **`services/UserDetailsServiceImpl.java`**: Bridges our `User` data with Spring Security's internal user system.

### 5. `payload`
**Responsibility**: Data Transfer Objects (DTOs).
- **`request/`** (e.g., `LoginRequest`): Defines what data the API expects to receive from the user (Email + Password).
- **`response/`** (e.g., `JwtResponse`): Defines what data the API sends back (Token + User Info).

### 6. `exception`
**Responsibility**: Handling errors gracefully.
- **`GlobalExceptionHandler.java`**: Catches crashes or errors (like "User not found" or "Invalid Password") and converts them into clean, readable JSON error messages instead of ugly system crash logs.
