# 🌍 Green Energy Data Demo

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![Docker](https://img.shields.io/badge/Containerized-Docker-blue)
![CI/CD](https://img.shields.io/badge/CI/CD-GitHub_Actions-yellow)

---

## 📖 Overview

This is a **simple Spring Boot REST API** that serves dummy green energy data.  
It demonstrates how to:
- Build a back-end Java service using **Spring Boot**
- Containerize the service using **Docker**
- Automate tests and builds using **GitHub Actions**

👉 This project is part of my personal *skills bridge* — moving my extensive experience with large-scale, regulated back-end systems into a **modern cloud-native stack** for mission-driven sectors like sustainability, clean tech, or scientific research.

---

## ⚡️ What It Does

When running, the API exposes a simple endpoint:

```
GET /energy
```

**Example response:**

```json
[
  "Solar: 42kWh",
  "Wind: 25kWh",
  "Hydro: 10kWh"
]
```

---

## 🚀 How to Run It Locally

### ✅ 1️⃣ Build the Project

Make sure you have **Java 17**, **Maven**, and **Docker Desktop** installed & running.

```bash
mvn clean package
```

---

### ✅ 2️⃣ Build the Docker Image

```bash
docker build -t green-energy-data-demo .
```

---

### ✅ 3️⃣ Run the Container

```bash
docker run -p 8080:8080 green-energy-data-demo
```

Then open your browser and visit:

```
http://localhost:8080/energy
```

You should see the energy data response!

---

## 🐙 CI/CD

A basic **GitHub Actions** workflow (`.github/workflows/maven.yml`) runs:
- `mvn package`
- `mvn test`

...on every push to `main`.

This demonstrates a clean **build pipeline** for a typical modern back-end project.

---

## 🔍 Why This Project Exists

> **“Bridging old to new.”**  
I’ve spent 12+ years building mission-critical, high-scale back-end systems in healthcare using core Java and custom-built architectures.

This project shows my practical commitment to mastering:
- **Modern frameworks** (Spring Boot)
- **Containerization** (Docker)
- **Automated pipelines** (CI/CD)

It connects what I *already know* (high-reliability, secure data systems) with today’s cloud-native stacks — ready for roles in **green energy**, **sustainability**, or **scientific R&D**.

---

## 🗺️ Next Steps

✔️ Add real datasets (e.g. open UK solar/wind data)  
✔️ Store and serve data from a database (PostgreSQL or MongoDB)  
✔️ Expand endpoints: `/forecast`, `/usage`, etc.  
✔️ Deploy to a cloud provider with automated pipelines

---

## 📜 License

This project is open for educational demonstration — feel free to fork, learn, or adapt!

---

**Built with ☕ + 🐳 + ⚙️ by Louis Swain**