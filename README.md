
# 🎓 Student Course Enrollment System

A Spring Boot backend application for managing student enrollments in courses. The system includes features for authentication, student and course management, and enrollment handling. Authentication is handled using JWT (JSON Web Tokens) to secure API endpoints.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Installation

1. Ensure you have Java 17+ installed.
2. Clone the repository.
3. Use Maven or Gradle to build the project.
4. Run the application with your IDE or command line:
```bash
mvn spring-boot:run
# or
./gradlew bootRun
```

## Usage

Once running, access the API at: http://localhost:8080

Interactive API documentation is available via Swagger UI at:
http://localhost:8080/swagger-ui/index.html

## API Endpoints

### 👤 Student Management (StudentController)

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| PUT    | /student/update/{id}  | Update student information by ID |
| POST   | /students             | Add a new student             |
| GET    | /students             | Retrieve all students         |
| GET    | /students/{id}        | Retrieve a student by their ID |

### 📚 Course Management (CourseController)

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | /Courses              | Retrieve all available courses |
| POST   | /Courses              | Add a new course              |
| GET    | /Courses/{id}         | Retrieve course details by ID |

### 📩 Enrollment Management (EnrollmentController)

| Method | Endpoint                        | Description                        |
|--------|--------------------------------|----------------------------------|
| POST   | /Enroll                        | Enroll a student in a course     |
| DELETE | /Unroll                       | Remove a student from a course   |
| GET    | /Enroll/{studentId}/courses    | List courses a student is enrolled in |
| GET    | /Enrolledstudents/{courseId}/courses | List students enrolled in a course |

Sample Request for Enrollment and Unroll:
```json
{
  "studentId": 1,
  "courseId": 2
}
```

## Authentication (AuthController)

Authenticate admin and obtain JWT token.

- POST /login

Request Body:
```json
{
  "username": "admin",
  "password": "admin"
}
```

Response:
```json
{
  "token": "JWT_TOKEN_HERE"
}
```

Include the token in the Authorization header for secured endpoints:
```
Authorization: Bearer JWT_TOKEN_HERE
```

## Technologies

- Java 17+
- Spring Boot
- Maven or Gradle
- JWT for Authentication
- Swagger for API documentation

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure code quality and proper documentation.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please open an issue on GitHub or contact the maintainer.
