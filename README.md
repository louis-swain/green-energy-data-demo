# 🌍 Green Energy Data Demo

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![HTML](https://img.shields.io/badge/HTML-5-orange)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.x-purple)
![Docker](https://img.shields.io/badge/Containerized-Docker-blue)
![CI/CD](https://img.shields.io/badge/CI/CD-GitHub_Actions-yellow)

---

## 📖 Overview

This is a **modern Spring Boot REST API** with a simple **HTML/Bootstrap view** for green energy data.  
It demonstrates how to:

- Build a robust back-end API with **Spring Boot**
- Store data in **PostgreSQL** with Docker Compose
- Serve human-friendly HTML using **Thymeleaf + Bootstrap**
- Add **pagination** to handle large datasets
- Automate builds/tests with **GitHub Actions**

👉 This project bridges my **deep experience** in regulated, high-scale Java systems with today’s **cloud-native** stacks — ready for **green energy**, **sustainability**, or **scientific data** roles.

---

## ⚡️ What It Does

**Core endpoints:**

- `GET /energy` → JSON API for programmatic use
- `GET /energy-view` → Paginated, Bootstrap-styled HTML table for humans
- `POST /import` → Upload a CSV to bulk-import green energy data

---

## 🚀 How to Run It Locally

### ✅ 1️⃣ Build the Project

Make sure you have **Java 17**, **Maven**, and **Docker Desktop** installed & running.

\`\`\`bash
mvn clean package
\`\`\`

---

### ✅ 2️⃣ Build & Start the Containers

\`\`\`bash
docker-compose up --build -d
\`\`\`

This spins up both the back-end and PostgreSQL DB with persistent storage.

---

### ✅ 3️⃣ Use the API or the HTML View

- **API (JSON)**: [http://localhost:8080/energy](http://localhost:8080/energy)
- **HTML View**: [http://localhost:8080/energy-view](http://localhost:8080/energy-view)

Use the HTML view to page through your data in a clean table.

---

### ✅ 4️⃣ Import a CSV

Use `curl` to POST a CSV:

\`\`\`bash
curl -X POST http://localhost:8080/import \
-H "Content-Type: multipart/form-data" \
-F "file=@yourfile.csv"
\`\`\`

✅ The file is processed once — your DB persists it thanks to Docker volumes.

---

## 🗂️ Tech Highlights

- **Languages/Frameworks:** Java 17, Spring Boot 3.x, Thymeleaf
- **DB:** PostgreSQL 16 in Docker
- **Containerization:** Docker & Compose
- **Frontend:** Bootstrap 5.x for a clean, responsive UI
- **CI/CD:** GitHub Actions for build/test automation
- **Extras:** Supports pagination, CSV import, API & HTML views

---

## 🗺️ Next Steps

✔️ Add data visualizations with **Chart.js**  
✔️ Add filters by fuel type or date range  
✔️ Add authentication for secure endpoints  
✔️ Deploy to a real cloud host (e.g., Heroku, Fly.io, Railway)

---

## 📜 License

This project is open for educational demonstration — fork it, learn from it, adapt it freely!

---

**Built by Louis Swain — bridging reliable, large-scale Java back-end skills into the modern sustainability & clean tech space.** ☕️🐳⚙️
