# 🌍 Green Energy Data Demo

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![HTML](https://img.shields.io/badge/HTML-5-orange)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.x-purple)
![Docker](https://img.shields.io/badge/Containerized-Docker-blue)
![CI/CD](https://img.shields.io/badge/CI/CD-GitHub_Actions-yellow)
![Tests](https://img.shields.io/badge/Tests-JUnit+Mockito-green)

---

## 📖 Overview

This is a **modern Spring Boot REST API** with a clean **HTML/Bootstrap view** for green energy data.  
It demonstrates how to:

- Build a robust back-end API with **Spring Boot**
- Store data in **PostgreSQL** with Docker Compose & volumes
- Serve human-friendly HTML using **Thymeleaf + Bootstrap**
- Add **pagination** for large datasets
- Automate builds & tests with **GitHub Actions**
- Write **unit & integration tests** with **JUnit5 + Mockito**

👉 It bridges my 12+ years in high-scale Java back-ends into modern **cloud-native**, **green tech**, or **scientific data** roles.

---

## ⚡️ What It Does

### ✅ REST API

- `GET /energy` → JSON list of all readings
- `POST /energy` → Add a single reading
- `POST /import` → Upload a CSV file

### ✅ Web UI

- `GET /energy-view` → Paginated HTML table of energy data
  - Filter by **fuel type**
  - Page through results
  - Clean Bootstrap styling

---

## 🚀 How to Run It Locally

### ✅ 1️⃣ Build the Project

Make sure you have **Java 17**, **Maven**, and **Docker Desktop** installed & running.

```bash
mvn clean package
```

---

### ✅ 2️⃣ Build & Start the Containers

```bash
docker-compose up --build -d
```

This spins up both the Spring Boot API and PostgreSQL DB with a persistent volume.

---

### ✅ 3️⃣ Use the API or the HTML View

- **API (JSON)**: [http://localhost:8080/energy](http://localhost:8080/energy)
- **HTML View**: [http://localhost:8080/energy-view](http://localhost:8080/energy-view)

Browse your green energy data in a clean Bootstrap table.

---

### ✅ 4️⃣ Import a CSV

Use `curl` to POST a CSV:

```bash
curl -X POST http://localhost:8080/import \
-H "Content-Type: multipart/form-data" \
-F "file=@yourfile.csv"
```

The file is processed once — your DB persists it in a Docker volume.

---

### ✅ 5️⃣ Run Tests Locally

To run **all unit tests** locally:

```bash
mvn test
```

---

## 🗂️ Tech Highlights

- **Languages/Frameworks:** Java 17, Spring Boot 3.x, Thymeleaf
- **DB:** PostgreSQL 16 in Docker
- **Containerization:** Docker & Compose
- **Frontend:** Bootstrap 5.x
- **CI/CD:** GitHub Actions
- **Testing:** JUnit5, Mockito, Spring Test
- **Extras:** Pagination, CSV import, API & HTML views

---

## 🗺️ Next Steps

✔️ Add data visualizations with **Chart.js**  
✔️ Add advanced filters (by date range)  
✔️ Add authentication for secure endpoints  
✔️ Deploy to a real cloud host

---

## 📜 License

This project is open for educational demonstration — fork it, learn from it, adapt it freely!

---

**Built by Louis Swain — bridging robust Java back-end skills into modern sustainability & clean tech.** ☕️🐳⚙️
