🎓 Student Course Enrollment System
A Spring Boot backend project that manages student enrollments in courses with JWT-based admin authentication.

🚀 Base URL

http://localhost:8080
🔐 Authentication (auth-controller)
▶️ POST /login
Description: Authenticate admin and return a JWT token.
Request Body:

{
  "username": "admin",
  "password": "admin"
}
Response:

{
  "token": "JWT_TOKEN_HERE"
}
Use the returned token to access secured endpoints by adding it in headers:
Authorization: Bearer JWT_TOKEN_HERE

👤 Student Controller (student-controller)
🔄 PUT /student/update/{id}
Description: Update student data.

📥 POST /students
Description: Add a new student.

📤 GET /students
Description: Get all students.

📌 GET /students/{id}
Description: Get a specific student by ID.

📚 Course Controller (course-controller)
📤 GET /Courses
Description: Retrieve all courses.

📥 POST /Courses
Description: Add a new course.

📌 GET /Courses/{id}
Description: Get course details by ID.

📩 Enrollment Controller (enrollment-controller)
📥 POST /Enroll
Description: Enroll a student in a specific course.

Sample Request:

{
  "studentId": 1,
  "courseId": 2
}
❌ DELETE /Unroll
Description: Unroll student from a specific course.

Sample Request:
{
  "studentId": 1,
  "courseId": 2
}
📚 GET /Enroll/{StudentId}/courses
Description: Get course names a student is enrolled in.

👥 GET /Enrolledstudents/{courseId}/courses
Description: Get student names enrolled in a course.

🧪 API Testing (Swagger UI)
Once the application is running, access Swagger UI at:

http://localhost:8080/swagger-ui/index.html
✅ Requirements
Java 17+

Maven or Gradle

Spring Boot

JWT for authentication
