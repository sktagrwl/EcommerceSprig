# 🛒 E-commerce Microservices Platform

A Spring Boot-based **microservices architecture** for an e-commerce platform.

Each service is modular, independently deployable, and communicates through **Netflix Eureka** for service discovery.

---

## 📦 Microservices Overview

- 🔹 **NetflixEurekaApplication** – Service Registry using Netflix Eureka  
- 🔹 **EcommerceSprig** – Product & Category Management Service  
- 🔹 **EcommerceOrderService** – Order Processing & Management Service  

---

## ✅ Prerequisites

Ensure the following tools are installed on your system:

- 🔸 Java 17 or higher  
- 🔸 Gradle (or use the provided `./gradlew`)  
- 🔸 MySQL Server  
- 🔸 Postman or cURL (for API testing)

---

## ⚙️ Environment Setup

Each service uses environment variables, configurable via a `.env` file or `application.properties`.

### 🧪 Sample `.env`

```
PORT=3000
EcommerceDB=jdbc:mysql://localhost:3306/ecommerce_db
DatasourceUsername=root
DatasourcePassword=password
```

### 📝 Sample `application.properties`

```properties
spring.application.name=EcommerceService
server.port=${PORT}
spring.datasource.url=${EcommerceDB}
spring.datasource.username=${DatasourceUsername}
spring.datasource.password=${DatasourcePassword}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

---

## 🚀 Getting Started

### 1️⃣ Clone Repositories

```bash
git clone https://github.com/sktagrwl/NetflixEurekaApplication
git clone https://github.com/sktagrwl/EcommerceSprig
git clone https://github.com/sktagrwl/EcommerceOrderService
```

### 2️⃣ Setup MySQL Databases

```sql
CREATE DATABASE ecommerce_db;
CREATE DATABASE order_db;
```

### 3️⃣ Configure Environment

Update the `.env` or `application.properties` for each service.

### 4️⃣ Run Services

Run each service in a separate terminal:

```bash
cd NetflixEurekaApplication && ./gradlew bootRun
cd EcommerceSprig && ./gradlew bootRun
cd EcommerceOrderService && ./gradlew bootRun
```

### 5️⃣ Access Eureka Dashboard

> 📍 Open your browser and go to:  
> `http://localhost:8761`

---

## 🧱 Architecture Overview

```
               +-------------------------+
               |     Eureka Server       |
               |  (Service Registry)     |
               +-----------^-------------+
                           |
           +---------------+---------------+
           |                               |
+---------------------+       +-------------------------+
|   Product Service    | <--> |     Order Service       |
|   (EcommerceSprig)   |       | (EcommerceOrderService) |
+---------------------+       +-------------------------+
```

---

## ✨ Features

### 🛍 Product Service (`EcommerceSprig`)
- Add / Edit / Delete products and categories  
- Retrieve products by ID or category  
- Built with layered architecture  
- Schema versioning with **Flyway**  
- Unit tests with **JUnit** & **Mockito**  
- Test coverage via **Jacoco**

### 📦 Order Service (`EcommerceOrderService`)
- Place new orders and retrieve them  
- Automatically stores associated order items  
- Uses **dotenv-java** for `.env` support  
- Eureka-based service discovery

### 🧭 Eureka Server (`NetflixEurekaApplication`)
- Centralized service registry  
- Tracks service availability and health  

---

## 🔌 API Endpoints

### 🛍 Product Service (Port 3000)
- `GET /api/products` – Get all products  
- `GET /api/products/id/{id}` – Get product by ID  
- `GET /api/categories` – Get all categories  
- `POST /api/categories` – Create a new category  
- `GET /api/categories/{id}/products` – Products under category  

### 📦 Order Service (Port 8081)
- `POST /api/orders` – Create a new order  
- `GET /api/orders/{id}` – Get order by ID  

---

## 🧪 Testing & Coverage

- **MockMvc** for integration testing  
- **Mockito** for mocking unit test dependencies  
- **Jacoco** for test coverage reports  

### Run tests
```bash
./gradlew test
```

### View coverage
Open in browser:  
`build/reports/jacoco/test/html/index.html`

---

## 🧰 Technologies Used

- Java 17  
- Spring Boot (MVC, REST, Eureka, JPA)  
- MySQL  
- Gradle  
- Flyway  
- Dotenv Java  
- JUnit & Mockito  
- Jacoco  
- Lombok

---

## 📌 Final Notes

- All services are modular and independently deployable  
- Service discovery handled via **Netflix Eureka**  
- Environment configuration supports `.env` files  
- Structured and tested for **scalability** and **maintainability**
