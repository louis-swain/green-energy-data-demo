# 🌍 Green Energy Data Demo

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)
![Docker](https://img.shields.io/badge/Containerized-Docker-blue)
![CI/CD](https://img.shields.io/badge/CI/CD-GitHub_Actions-yellow)

---

## 📖 Overview

This is a **simple Spring Boot REST API** that stores and serves green energy readings via a PostgreSQL database.  
It demonstrates how to:
- Build a back-end Java service using **Spring Boot** & **Spring Data JPA**
- Containerize the whole stack using **Docker Compose**
- Mock out dependencies for fast **unit & web tests**
- Prepare for automated builds with **GitHub Actions**

👉 This is part of my personal *skills bridge* — proving how my experience in large-scale, regulated back-end systems maps to a **modern cloud-native stack** for mission-driven sectors like sustainability, clean tech, or scientific research.

---

## ⚡️ What It Does

When running, the API exposes two simple endpoints:

```
GET /energy
POST /energy
```

**Example POST body (no `id` needed — the DB generates it):**

```json
{
  "source": "Solar",
  "kWh": 42.5
}
```

Stored data is saved in a **PostgreSQL** container and returned as JSON.

---

## 🚀 How to Run It Locally

### ✅ 1️⃣ Build the Project

Make sure you have **Java 17**, **Maven**, and **Docker Desktop** running.

```bash
mvn clean package
```

---

### ✅ 2️⃣ Run with Docker Compose

```bash
docker-compose up --build
```

This spins up:
- `postgres` — the database
- `app` — the Spring Boot service

---

### ✅ 3️⃣ Test the API

**GET all readings:**
```bash
curl http://localhost:8080/energy
```

**POST a reading:**
```bash
curl -X POST http://localhost:8080/energy \
  -H "Content-Type: application/json" \
  -d '{"source":"Solar","kWh":42.5}'
```

---

## 🧪 Tests

A basic **controller test**:
- Uses `@WebMvcTest` for a lightweight web slice.
- Uses `@MockBean` to mock the repository — no real DB needed.
- Runs automatically with:
  ```bash
  mvn test
  ```

---

## 🐙 CI/CD

A basic **GitHub Actions** workflow (`.github/workflows/maven.yml`) can run:
- `mvn clean package`
- `mvn test`

...on every push to `main`.

---

## 🔍 Why This Project Exists

> **“Bridging old to new.”**  
I spent 12+ years building mission-critical, high-scale back-end systems in healthcare, using core Java and bespoke architectures.

This shows I’m mastering:
- **Modern frameworks** (Spring Boot, JPA)
- **Containerization** (Docker Compose)
- **Test best practices** (MockMvc, mocks)
- **Pipeline readiness** (CI/CD)

✅ It connects what I *already know* — performance, reliability, security — to today’s **cloud-native stacks** ready for roles in **green energy**, **sustainability**, or **scientific R&D**.

---

## 🗺️ Next Steps

✔️ Add real open datasets (e.g. UK solar/wind data)  
✔️ Add custom queries to the repository (e.g. find by source)  
✔️ Write integration tests with **Testcontainers**  
✔️ Expand the API: `/forecast`, `/usage`, `/stats`  
✔️ Deploy to a cloud provider with a CI/CD pipeline

---

## 📜 License

Open for learning & demonstration — fork or adapt freely!

---

**Built with ☕ + 🐳 + ⚙️ by Louis Swain**
