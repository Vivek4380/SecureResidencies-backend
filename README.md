# SecureResidencies Backend

SecureResidencies is a hostel management backend system built using Spring Boot.
It is designed to digitize student movement, streamline hostel operations, and assist wardens in monitoring activities.

---

## 🚀 Features

### 🔐 Authentication & Registration

* Student registration with email verification
* Login system with role-based structure
* Password encryption using Spring Security

### 🚪 Entry–Exit (Gate Pass System)

* Students can request gate passes
* Wardens can approve or reject requests
* Gate pass status tracking system
* Email notifications for approvals/rejections

### 🧹 Room Cleaning Management

* Slot-based room cleaning booking system
* Availability tracking for slots
* Booking management with validation

### 📝 Complaint Management

* Students can raise complaints
* Wardens can update complaint status
* Centralized complaint tracking system

### 👨‍💼 Warden Controls

* Manage complaints
* Approve/reject gate passes
* Monitor hostel activities

---

## 🧱 Tech Stack

* Java
* Spring Boot
* Spring Security
* Maven
* SMTP (Mailtrap / Local SMTP for testing)

---

## 📁 Project Structure

```
com.example.hostel
│
├── login                # Authentication & user management
├── entry_exit_flow      # Gate pass and resident management
├── complaint            # Complaint system
├── cleaning             # Room cleaning module
├── warden               # Warden-specific operations
```

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```
git clone https://github.com/Vivek4380/SecureResidencies-backend.git
cd SecureResidencies-backend
```

### 2. Configure application properties

Create a file:

```
src/main/resources/application.properties
```

Add your configuration:

```
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.mail.host=YOUR_SMTP_HOST
spring.mail.port=YOUR_SMTP_PORT
spring.mail.username=YOUR_EMAIL
spring.mail.password=YOUR_PASSWORD
```

### 3. Run the application

```
./mvnw spring-boot:run
```

---

## 🧠 Future Enhancements

* Integration with geofencing for automatic entry/exit tracking
* JWT-based authentication system
* Mobile app integration
* Real-time notifications

---

## 📌 Note

This project was developed as a second-year academic project and focuses on backend system design and modular architecture.

---
