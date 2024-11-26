# SocialMedia Microservices

This repository contains the **SocialMedia** application, which is currently being converted from a monolithic architecture to a microservices-based architecture. The project is built using the **Java technology stack**, leveraging **Spring Boot** for rapid development and **MySQL** for database management.

---

## 🚀 Features and Highlights

### Monolithic to Microservices Transition
The SocialMedia application is being modularized into several microservices for improved scalability and maintainability.  

#### Implemented Microservices:
1. **Currency Conversion Service**
2. **Currency Exchange Service**
3. **Limit Service**

### Technology Stack
- **Programming Language**: Java  
- **Frameworks**: Spring, Spring Boot  
- **Database**: MySQL  
- **ORM**: JPA, Hibernate  
- **REST API Development**: Built using RESTful principles  

### Microservices Infrastructure
- **Eureka Naming Server**: For service discovery and registration.
- **API Gateway**: Centralized entry point to route requests to appropriate microservices.
- **Spring Cloud Config**: Externalized configuration management for microservices.

---

## 🛠️ Key Concepts and Implementations

### REST API Development
The following advanced REST API concepts have been implemented:
- **Custom Exception Handling**: Gracefully handle errors with user-friendly messages.
- **Validation**: Enforce rules for incoming requests.
- **Swagger Documentation**: Comprehensive API documentation for easy consumption.
- **Jackson Dependency**: Support for multiple representations (e.g., JSON, XML).
- **Versioning**: Support for versioned APIs for backward compatibility.
- **HATEOAS**: Hypermedia as the Engine of Application State for richer API interactions.
- **Customizing Responses**: 
  - Serialization and field name customization.
  - Selective field filtering in responses.
- **Pagination**: Efficiently handle large datasets.
- **Model Mapper**: Simplify data transformations.

  ### ASCII-style UML diagram
![image](https://github.com/user-attachments/assets/2179fc66-1cd2-4dc0-829e-08938d6f240f)

### Monitoring and Actuators
- **Spring Boot Actuator**: Provides insights into the application's health, metrics, and runtime state.

---

## 📜 Folder Structure
socialmedia
├── api-gateway
├── cloud-config
├── currency-conversion-service
├── currency-exchange-service
├── limit-service
└── common-modules


---

## 📖 Documentation
- **Swagger**: Available for each service to explore API endpoints.
- **HATEOAS**: Included in API responses for navigation.

---

## 🛑 Prerequisites
- **Java**: JDK 17 or later
- **Spring Boot**: Version 3.x
- **MySQL**: Ensure the database is running and accessible.

---

## 🔧 How to Run
1. Clone the repository.
2. Set up the **MySQL database** and update the connection details in each service's `application.properties`.
3. Start the **Eureka Naming Server**.
4. Start the **Spring Cloud Config Server** with proper configuration.
5. Start each microservice one by one.
6. Access the **API Gateway** for testing endpoints.

---

## 🤝 Contribution
Feel free to fork the repository and contribute! Contributions, issues, and feature requests are welcome.  

---

## 🛡️ License
This project is licensed under the MIT License.

---

### Happy Coding! 😊
