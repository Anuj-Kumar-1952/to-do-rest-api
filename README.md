# To-Do List REST API (Spring Boot)

A simple **To-Do List REST API** built using **Spring Boot, Java, and MySQL**, allowing users to manage tasks efficiently. Users can create, view, update, and delete tasks.

---

## Features
- Create a new task
- View all tasks or a specific task
- Update a task (including marking as completed)
- Delete a task
- Tasks include: title, description, status, priority, and optional due date

---

## Technology Stack
- **Backend:** Java, Spring Boot, Spring MVC, Spring Data JPA
- **Database:** MySQL
- **Build Tool:** Maven
- **IDE:** VS Code

---

## Getting Started

### 1. Clone the repository
git clone https://github.com/Anuj-Kumar-1952/to-do-rest-api.git
cd to-do-rest-api

### 2. Configure MySQL Database
Edit src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

###3. Build and Run the Application
Using Maven:
mvn clean install
mvn spring-boot:run

Application runs on:
http://localhost:8080/todo

###4. API Endpoints
Method	   Endpoint	         Description
GET	       /api/tasks	       Get all tasks
GET	       /api/tasks/{id}	 Get a specific task by ID
POST	     /api/tasks	       Create a new task
PUT	       /api/tasks/{id}	 Update a task
DELETE	   /api/tasks/{id}	 Delete a task

###5. Notes
Status can be PENDING or COMPLETED only.
Priority can be LOW, MEDIUM, or HIGH.
Dates should be in YYYY-MM-DD format.
Make sure MySQL is running and database is created before running the application.

## Postman Collection
You can import the Postman collection to test the API:

[Download Postman Collection](postman/To_Do_List%20_API_collection.json)
