# Postman / API Testing Cheat Sheet

Copy and paste these JSON snippets into the **Body -> raw -> JSON** section of Postman to test your endpoints.

---

## 1. Authentication

### **Signup (Register a new user)**
**Method:** `POST`
**URL:** `https://localhost:8443/api/auth/signup`
**Body:**
```json
{
    "name": "Test User",
    "email": "test@example.com",
    "password": "password123",
    "role": "user"
}
```

### **Login**
**Method:** `POST`
**URL:** `https://localhost:8443/api/auth/login`
**Body:**
```json
{
    "email": "test@example.com",
    "password": "password123"
}
```
**👉 ACTION:** Copy the `token` from the response. You will need it for the next steps!
**⚠️ NOTE:** In Postman settings, turn **OFF** "SSL certificate verification" since we use a self-signed cert.

---

## 2. Products

### **Get All Products (Public)**
**Method:** `GET`
**URL:** `https://localhost:8443/api/products`
**Auth:** None needed.

### **Create Product (Restricted)**
**Method:** `POST`
**URL:** `https://localhost:8443/api/products`
**Auth:** Select **Bearer Token** type and paste your token.
**Body:**
```json
{
    "name": "Super Gaming Mouse",
    "description": "High DPI, RGB lighting",
    "price": 59.99
}
```

### **Update Product (Owner Only)**
**Method:** `PUT`
**URL:** `https://localhost:8443/api/products/{id}` (Replace `{id}` with an actual ID from the Get All list)
**Auth:** Bearer Token
**Body:**
```json
{
    "name": "Super Gaming Mouse V2",
    "description": "Now with even more RGB!",
    "price": 69.99,
    "userId": "dont_worry_backend_ignores_this"
}
```

### **Delete Product (Owner Only)**
**Method:** `DELETE`
**URL:** `https://localhost:8443/api/products/{id}`
**Auth:** Bearer Token

---

## 3. Admin Capabilities

### **Signup as Admin**
**Method:** `POST`
**URL:** `https://localhost:8443/api/auth/signup`
**Body:**
```json
{
    "name": "Admin Boss",
    "email": "admin@example.com",
    "password": "adminpassword",
    "role": "admin"
}
```

### **Login as Admin**
**Method:** `POST`
**URL:** `https://localhost:8443/api/auth/login`
**Body:**
```json
{
    "email": "admin@example.com",
    "password": "adminpassword"
}
```

### **Get All Users (Admin Only)**
**Method:** `GET`
**URL:** `https://localhost:8443/api/users`
**Auth:** Bearer Token (must use the Admin token)

### **Get My User Details (User or Admin)**
**Method:** `GET`
**URL:** `https://localhost:8443/api/users/{id}` (Replace `{id}` with your own user ID from the login response)
**Auth:** Bearer Token
*Note: Users can only view their own profile. Admins can view any profile.*
