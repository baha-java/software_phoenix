Software Phoenix Java Spring Project

This repository contains the code for a Java Spring project developed for Software Phoenix. The project includes functionalities for user registration, authentication, request handling, and news listing using RestAPI.

Requirements

    Java Development Kit (JDK) 17
    PostgreSQL 11 (optional, for database setup)
    Docker (for containerization)
    Spring Boot 3.2.5
    Maven for dependency management

## Functionality and Endpoints
### User Registration
- Endpoint: /api/v1/auth/signup :
- Description: Register a new user.
- Input data:
  - Login
  - Password
  - Password Confirmation
  - Full Name
  - Reference to avatar
- Checks:
  - Password Compliance
  - Unique login

### User Authorization
- Endpoint: /api/v1/auth/signin :
- Description: User authentication and JWT token issuance.
- Input data:
  - Login
  - Password
- Used by JWT for user authentication.

### Accepting Application
- Endpoint: /api/v1/delivery ː
- Description: Add a new application to the system.
- Input: The object of the application in any form (e.g.: goods, quantity, delivery address, telephone number).

### Getting a List of Entries
- Endpoint: /api/v1/delivery ː
- Description: Get a list of all applications from the database.
