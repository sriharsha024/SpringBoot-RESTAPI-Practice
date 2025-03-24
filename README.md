# SpringBoot-RESTAPI-Practice

Employee Management & Thymeleaf with Spring Boot

This repository demonstrates various features and best practices in Spring Boot, including RESTful APIs, Thymeleaf templating, and entity relationships for an employee management system. The project includes multiple CRUD operations, API integrations, and dynamic content rendering using Thymeleaf.

Key Features & Commit Highlights

Employee Management API

CRUD Operations: Implemented Employee Management API with basic CRUD operations for managing employee data.

Relationships: Defined relationships between entities like Employee, SalaryAccount, EmployeeAddress, and Projects with proper cascade types and fetch strategies.

Validation & Error Handling: Included necessary validation for employee creation and updates, with proper error handling for different scenarios.

API Endpoints: Created RESTful API endpoints using @GetMapping, @PostMapping, @RequestBody, and @PathVariable to handle request payloads and dynamic URL parameters.

Thymeleaf Templates

Conditional Statements: Demonstrated Thymeleaf conditional statements to dynamically display content on the front end.

Iteration: Used Thymeleaf iteration to loop through lists and display dynamic data on web pages.

Fragments: Applied Thymeleaf fragments for code reusability across different views and templates.

Dynamic Content: Created a homepage with dynamic content and JavaScript to make the web application interactive.

Social Media Platform Schema

Entities & Relationships: Implemented multiple entities with complex relationships in the context of a social media platform, showcasing @ManyToOne, @OneToMany, and @OneToOne relationships, along with cascade and fetch types.

Technologies Used

Spring Boot (for RESTful API and backend logic)

Thymeleaf (for dynamic web content rendering)

Java (for backend development)

JPA (for entity relationships and database operations)

Spring Data JPA (for simplifying database interactions)

Hibernate (for managing ORM and relationships)

JavaScript (for dynamic content and interaction)
