# User Access Management System

A Java-based web application to manage user access requests to software applications. Users can register, log in, and request access to applications. Managers can review these requests and approve or reject them.

## Features
- User Registration and Login
- Role-based access:
  - Employees: Request software access.
  - Managers: Approve or reject access requests.
  - Admins: Create and manage software applications.
- Access requests with status tracking.

## Technologies Used
- **Java Servlets** and **JSP** for the backend
- **PostgreSQL** for database management
- **Apache Tomcat** as the server
- **Maven** for project management

## Project Structure

UserAccessManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── access/
│   │   │           ├── servlet/
│   │   │           │   ├── SignUpServlet.java
│   │   │           │   ├── LoginServlet.java
│   │   │           │   ├── SoftwareServlet.java
│   │   │           │   ├── RequestServlet.java
│   │   │           │   └── ApprovalServlet.java
│   │   │           └── model/
│   │   │               └── DatabaseUtils.java
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       └── jsp/
│   │           ├── signup.jsp
│   │           ├── login.jsp
│   │           ├── createSoftware.jsp
│   │           ├── requestAccess.jsp
│   │           └── pendingRequests.jsp
├── pom.xml
├── README.md
└── database_setup.sql



## Setup Instructions

1. **Install PostgreSQL** and create a new database for the project.
2. **Run the Database Script**:
   - Execute the SQL file `database_setup.sql` located in the `sql` folder to create the necessary tables.
3. **Configure Database Connection**:
   - Open `DatabaseUtils.java` and set your database connection details (`URL`, `username`, `password`).
4. **Build and Deploy**:
   - Use Maven to build the project:
     ```bash
     mvn clean install
     ```
   - Deploy the `.war` file to Apache Tomcat.

5. **Run the Application**:
   - Start Apache Tomcat and access the application at `http://localhost:8080/UserAccessManagementSystem`.

## Usage Guide

1. **Sign Up**:
   - Access `signup.jsp` to create a new Employee account.
2. **Login**:
   - Employees are redirected to request access (`requestAccess.jsp`).
   - Managers are redirected to view pending requests (`pendingRequests.jsp`).
   - Admins are redirected to create software applications (`createSoftware.jsp`).
3. **Request Access (Employee)**:
   - On `requestAccess.jsp`, select software, access type, and provide a reason, then submit the request.
4. **Approve/Reject Requests (Manager)**:
   - On `pendingRequests.jsp`, review each request and choose to approve or reject it.
5. **Create Software (Admin)**:
   - On `createSoftware.jsp`, add new software applications for access requests.

## Important Notes

- **Session Management**: Ensure session attributes are set correctly for role-based redirection.
- **Access Control**: Only users with the correct roles can access specific pages. Unauthorized access redirects to `login.jsp`.
- **Error Handling**: Basic error handling with `error.jsp`.

## Troubleshooting

- If there are database connection issues, ensure PostgreSQL is running and `DatabaseUtils.java` contains the correct credentials.
- Check Tomcat logs for detailed errors if the application doesn’t start.

## License

This project is for educational purposes and follows an open-use license.
