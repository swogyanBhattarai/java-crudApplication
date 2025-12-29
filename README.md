# CRUD Application (Spring Boot)

## Overview

This project is a **Spring Boot CRUD application** that demonstrates clean backend architecture using **Entities, DTOs, Services, Repositories, and Controllers**. It exposes RESTful APIs for managing **Users** and **Orders**, following industry-standard best practices such as DTO separation, validation, and layered design.

The application is designed to be easily consumable by a frontend (React, Angular, etc.) or API testing tools like Postman.

---

## Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Web (REST APIs)**
* **Spring Data JPA**
* **Hibernate**
* **Jakarta Validation**
* **H2 / MySQL (configurable)**
* **Maven**

---

## Project Structure

```
src/main/java/com/example/crudapp
│
├── controller      # REST controllers (API layer)
├── service         # Business logic layer
├── repository      # JPA repositories (data access layer)
├── model           # JPA entities
├── dto             # Data Transfer Objects
└── CrudAppApplication.java
```

### Why this structure?

* **Controllers** handle HTTP requests and responses
* **Services** contain business logic
* **Repositories** interact with the database
* **Entities (Models)** represent database tables
* **DTOs** control what data enters and leaves the API

This separation ensures maintainability, security, and scalability.

---

## Domain Model

### User

A user can have multiple orders.

**Fields:**

* `id`
* `name`
* `email`
* `createdAt`
* `updatedAt`

### Order

Each order belongs to one user.

**Fields:**

* `orderId`
* `productName`
* `productPrice`
* `user`
* `createdAt`
* `updatedAt`

---

## DTO Design

### Why DTOs?

DTOs are used to clearly separate **API contracts** from **database entities**. This prevents overexposing internal models, avoids circular references, and gives precise control over validation and response shape.

Each operation (create, update, response) has its own DTO with a specific responsibility.

---

### User DTOs

#### UserCreateDTO

Used when creating a new user.

**Purpose:**

* Accepts input data for user creation
* Enforces validation rules

**Fields:**

* `name` (2–20 characters, not blank)
* `email` (valid email, not null)

---

#### UserUpdateDTO

Used for updating an existing user.

**Purpose:**

* Allows partial updates
* No required fields

**Fields:**

* `name` (optional, 2–20 characters)
* `email` (optional, valid email)

---

#### UserResponseDTO

Used for returning user data to the client.

**Purpose:**

* Safe API response structure
* Avoids exposing internal entity relationships

**Fields:**

* `id`
* `name`
* `email`
* `orders` (list of `OrderResponseDTO`)
* `createdAt`
* `updatedAt`

---

### Order DTOs

#### OrderCreateDTO

Used when creating a new order.

**Fields:**

* `productName`
* `productPrice`
* `userId`

---

#### OrderUpdateDTO

Used for updating an order.

**Fields:**

* `productName` (optional)
* `productPrice` (optional)

---

#### OrderResponseDTO

Used for returning order data.

**Fields:**

* `id`
* `productName`
* `productPrice`
* `userId`
* `createdAt`
* `updatedAt`

---

## Validation

Validation is handled using **Jakarta Validation** annotations:

* `@NotNull`
* `@Size`
* `@DecimalMin`
* `@Digits`

Invalid requests automatically return **400 Bad Request** with validation messages.

---

## Error Handling

* `RuntimeException("Order/User not found")` is thrown when an ID does not exist
* Returns HTTP **500** by default (can be improved with `@ControllerAdvice`)

---

## Testing

You can test the APIs using:

* Postman
* Curl
* Frontend application

---

## Key Concepts Demonstrated

* RESTful API design
* DTO-based architecture
* JPA entity relationships
* Validation and clean input handling
* Service-layer business logic

---

## Future Improvements

* Global exception handling (`@ControllerAdvice`)
* Pagination and sorting
* Authentication and authorization (Spring Security)
* Mapper layer (MapStruct)

---

## Author

Built as a learning-focused Spring Boot CRUD project following backend best practices.
