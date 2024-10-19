# Task Management API
## Project Overview

This project is a RESTful API built in Java that allows managing tasks and projects. The API will include CRUD operations (Create, Read, Update, Delete) for both entities: Task and Project. This project is developed using Test-Driven Development (TDD), where tests are written before implementing the actual functionality.

## Functional Requirements
### Entity: Task
- Fields: id, title, description, status (enum: PENDING, IN_PROGRESS, COMPLETED), dueDate, projectId (foreign key for project relation).
- The status should be updated based on the progress of the task.
- It must be possible to filter tasks by status and dueDate.

### Entity: Project

- Fields: id, name, description, startDate, endDate.
- A project can have multiple tasks associated with it.

## API Endpoints

### ProjectController
- GET /projects - Retrieve a list of all projects.
- GET /projects/{id} - Retrieve a project by its id.
- POST /projects - Create a new project.
- Data to send: name, description, startDate, endDate.
- PUT /projects/{id} - Update an existing project.
- DELETE /projects/{id} - Delete a project.

### TaskController
- GET /tasks - Retrieve a list of all tasks.
- GET /tasks/{id} - Retrieve a task by its id.
- POST /tasks - Create a new task.
- Data to send: title, description, status, dueDate, projectId.
- PUT /tasks/{id} - Update an existing task.
- DELETE /tasks/{id} - Delete a task.
- GET /tasks/search?status={status} - Search for tasks by status (PENDING, IN_PROGRESS, COMPLETED).
- GET /tasks/search?dueDate={date} - Search for tasks by due date.

## Frontend Requirements (API Endpoints to Consume)
### 1. Project View:

- Display a list of all projects using GET /projects.
- Create, update, and delete projects using the respective endpoints.

### 2.Task View:

- Display a list of tasks filtered by project.
- Create, update, and delete tasks.
- Filter tasks by status and due date.

## Technical Requirements
- The API should include data validation and proper error handling.
- The project must follow TDD practices, writing tests before implementing functionality.
- The project should generate automatic API documentation using Swagger (OpenAPI).
