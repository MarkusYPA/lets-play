# Implementation Plan

## Phase 1: Foundation & Dependencies
1.  **Enhance `pom.xml`**: 
    - Add `spring-boot-starter-validation` for input validation (@NotNull, @Email, etc.).
    - Add JWT dependencies (`jjwt-api`, `jjwt-impl`, `jjwt-jackson`) to support token-based authentication.
2.  **Refine Models**:
    -   Update `User.java`: Add Lombok annotations (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`) and Validation annotations.
    -   Update `Product.java`: Add Lombok annotations and Validation annotations.

## Phase 2: Security & Authentication
3.  **Security Configuration**:
    -   Create `SecurityConfig.java`.
    -   Implement `SecurityFilterChain` to:
        -   Disable CSRF.
        -   Set session management to `STATELESS`.
        -   Configure path permissions (Public vs Protected).
4.  **Token Logic**:
    -   Create `JwtUtils.java` for generating and parsing tokens.
    -   Create `AuthTokenFilter.java` (OncePerRequestFilter) to validate tokens on each request.
5.  **User Details**:
    -   Implement `UserDetailsServiceImpl.java` (loads user from DB).
    -   Implement `UserDetailsImpl.java` (adapter for Spring Security).
6.  **Auth Controller**:
    -   Create `AuthController.java` with `/signup` and `/login` endpoints.

## Phase 3: API Implementation
7.  **Product API**:
    -   Refine `ProductController.java`.
    -   Implement `create` (POST), `update` (PUT), `delete` (DELETE).
    -   Ensure `userId` is set from the authenticated context.
8.  **User API**:
    -   Create `UserController.java`.
    -   Implement standard CRUD operations.
    -   Secure sensitive operations (e.g., admin-only delete).
9.  **Error Handling**:
    -   Create `GlobalExceptionHandler.java` (@ControllerAdvice).
    -   Handle `MethodArgumentNotValidException` (validation errors) and generic exceptions ensuring no 5XX errors leak internal details.

## Phase 4: Polish & Review
10. **Bonus Features**:
    -   Add CORS configuration in `SecurityConfig` or `WebMvcConfig`.
    -   (Optional) Rate limiting.
11. **Final Verification**:
    -   Test all endpoints using the curl commands in `README.md`.
