🎓 Student Course Enrollment System

A Spring Boot backend application for managing student enrollments in courses. The system includes features for authentication, student and course management, and enrollment handling. Authentication is handled using JWT (JSON Web Tokens) to secure API endpoints.

🚀 Base URL
http://localhost:8080

🔐 Authentication (AuthController)
POST /login
Description:
Authenticates an admin user and returns a JWT token for accessing secured endpoints.

Request Body:
{
  "username": "admin",
  "password": "admin"
}
Response:
{
  "token": "JWT_TOKEN_HERE"
}

🔒 Note: Include the returned token in the Authorization header when calling secured APIs:
Authorization: Bearer JWT_TOKEN_HERE

👤 Student Management (StudentController)
PUT /student/update/{id}
Update student information by their ID.

POST /students
Add a new student to the system.

GET /students
Retrieve a list of all students.

GET /students/{id}
Retrieve details of a specific student by their ID.

📚 Course Management (CourseController)
GET /Courses
Retrieve all available courses.

POST /Courses
Add a new course to the system.

GET /Courses/{id}
Retrieve details of a specific course by its ID.

📩 Enrollment Management (EnrollmentController)
POST /Enroll
Enroll a student in a specific course.

Sample Request:

{
  "studentId": 1,
  "courseId": 2
}

DELETE /Unroll
Remove a student from a specific course.

Sample Request:

{
  "studentId": 1,
  "courseId": 2
}
GET /Enroll/{studentId}/courses
Retrieve the list of course names a student is enrolled in.

GET /Enrolledstudents/{courseId}/courses
Retrieve the names of students enrolled in a specific course.

🧪 API Testing
Access Swagger UI for interactive API testing once the application is running:

http://localhost:8080/swagger-ui/index.html

✅ Requirements
Java 17+

Maven or Gradle

Spring Boot

JWT (JSON Web Token) for Authentication














