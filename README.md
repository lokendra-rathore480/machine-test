Technology Stack:

Java: JDK 17
Spring Boot
Spring Data JPA
Hibernate
MySQL 8.0
Maven
REST API

Database Details:

Database: MySQL
Database Name: machine-test

Requirements:

JDK 17
MySQL 8.0+
Maven 3.9+
IDE: IntelliJ IDEA / Eclipse / Spring Tool Suite (STS)

Steps to Run the Project:

Clone the repository from GitHub.
Create the MySQL database named machine-test.
Update the database username and password in application.properties.
Run mvn clean install.
Start the application.
Access the application at:
API: http://localhost:8080

Postman Collection:
http://localhost:8080/api/v1/auth/login
http://localhost:8080/api/v1/auth/register
http://localhost:8080/api/v1/admin/home
http://localhost:8080/api/v1/customer/
http://localhost:8080/products/create
http://localhost:8080/api/products/all
http://localhost:8080/api/products?tag='fashion'

