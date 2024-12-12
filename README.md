# Bike Center API

This is a REST API developed in Spring Boot for a bike center. The API allows users to view information about available bikes, including name, price, category, etc. It also includes methods to create, delete, update, and retrieve bikes.

## Requirements

- Java 11 or higher
- Maven 3.6.0 or higher
- PostgreSQL

## Environment Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/sqada2804/bike-center-api.git
   cd bike-center-api
   
2. Set up the database:

Make sure you have PostgreSQL installed and running.

Create a database named bike_center.

sql
CREATE DATABASE bike_center;
Configure the database credentials in the application.properties file located in src/main/resources/:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bike_center
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Running the Project
Build and run the application:

bash
mvn spring-boot:run
Access Swagger UI:

Open your browser and navigate to http://localhost:3000/swagger-ui.html.

In Swagger UI, you will see all the available methods to create, delete, update, and get available bikes.

Endpoints
Bikes
GET /v1/bikes - Retrieve all bikes.

GET /v1/bikes/{id} - Retrieve a bike by ID.

POST /v1/bikes - Create a new bike.

PUT /v1/bikes/{id} - Update an existing bike.

DELETE /v1/bikes/{id} - Delete a bike.

Example Bike JSON
json
{
  "id": 1,
  "name": "Mountain Bike",
  "price": 599.99,
  "category": "Mountain",
  "description": "A sturdy mountain bike for all terrains."
}

Technologies Used
Spring Boot
Spring Data JPA
PostgreSQL
Swagger
Maven
