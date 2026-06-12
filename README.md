# SecureResidencies Backend

A hostel management REST API built with Java and Spring Boot.
Designed to digitize and streamline hostel operations including
student gate pass requests, complaint tracking, and room cleaning schedules.

## Tech Stack
- Java 21
- Spring Boot 3.4.6
- Spring Security
- Spring Data JPA
- H2 In-Memory Database
- Maven
- Lombok

## Project Structure
- config/ - Security configuration
- controller/ - REST API endpoints
- service/ - Business logic
- repository/ - Database operations
- entity/ - Database models
- dto/ - Request and Response objects
- exception/ - Global error handling

## Features

### Gate Pass Management
Students can request gate passes. Wardens can approve or reject.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/gatepasses | Create gate pass request |
| GET | /api/gatepasses | Get all gate passes |
| GET | /api/gatepasses/{id} | Get gate pass by ID |
| GET | /api/gatepasses/resident/{email} | Get by student email |
| GET | /api/gatepasses/status/{status} | Get by status |
| PATCH | /api/gatepasses/{id}/status | Update status |
| DELETE | /api/gatepasses/{id} | Delete gate pass |

### Complaint Management
Students raise complaints. Wardens update status.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/complaints | Raise a complaint |
| GET | /api/complaints | Get all complaints |
| GET | /api/complaints/{id} | Get complaint by ID |
| GET | /api/complaints/status/{status} | Get by status |
| PATCH | /api/complaints/{id}/status | Update status |
| DELETE | /api/complaints/{id} | Delete complaint |

### Room Cleaning Booking
Students book cleaning slots. Wardens track uncleaned rooms.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/bookings | Book a cleaning slot |
| GET | /api/bookings | Get all bookings |
| GET | /api/bookings/{id} | Get booking by ID |
| GET | /api/bookings/search?date=&roomNumber= | Search by date and room |
| GET | /api/bookings/uncleaned | Get uncleaned rooms |
| PATCH | /api/bookings/{id}/mark-cleaned | Mark as cleaned |
| DELETE | /api/bookings/{id} | Delete booking |

## Setup and Run

### 1. Clone the repository
git clone https://github.com/Vivek4380/SecureResidencies-backend.git
cd SecureResidencies-backend

### 2. Run the application
./mvnw spring-boot:run

No database setup needed - uses H2 in-memory database automatically.

### 3. Access the API
http://localhost:8080

### 4. Access H2 Database Console
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:hosteldb
Username: sa
Password: leave empty

## Sample API Requests

Create a Complaint:
curl -X POST http://localhost:8080/api/complaints -H "Content-Type: application/json" -d '{"category":"PLUMBER","roomNumber":"101","description":"Pipe is leaking"}'

Create a Gate Pass:
curl -X POST http://localhost:8080/api/gatepasses -H "Content-Type: application/json" -d '{"visitReason":"Family visit","emergencyContact":"9876543210","leaveDate":"2026-06-15","returnDate":"2026-06-16","residentEmail":"student@hostel.com"}'

Book a Cleaning Slot:
curl -X POST http://localhost:8080/api/bookings -H "Content-Type: application/json" -d '{"date":"2026-06-15","slot":"MORNING","roomNumber":"101"}'

Approve a Gate Pass:
curl -X PATCH "http://localhost:8080/api/gatepasses/1/status?status=APPROVED"

## Enum Values

Complaint Categories: ELECTRICIAN, FURNITURE, PLUMBER, OTHERS
Complaint Status: PENDING, IN_PROGRESS, RESOLVED
Gate Pass Status: PENDING, APPROVED, REJECTED
Booking Slots: MORNING, AFTERNOON, EVENING

## Note
This project was built as a personal backend portfolio project
to demonstrate Spring Boot REST API development with clean layered architecture.
