# Shortify-URL

[![Build Status](https://github.com/Yash-Ahire-2004/Shortify-URL/actions/workflows/maven.yml/badge.svg)](https://github.com/Yash-Ahire-2004/Shortify-URL/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](./LICENSE)
[![Language](https://img.shields.io/github/languages/top/Yash-Ahire-2004/Shortify-URL)](https://github.com/Yash-Ahire-2004/Shortify-URL)
[![Repo Size](https://img.shields.io/github/repo-size/Yash-Ahire-2004/Shortify-URL)](https://github.com/Yash-Ahire-2004/Shortify-URL)

A simple URL shortener built with Spring Boot and JPA.

## ✅ Overview

- **Project:** Shortify-URL
- **Tech stack:** Java 17, Spring Boot 4, Maven, PostgreSQL, JPA
- **Default port:** 8081 (configured in `src/main/resources/application.properties`)

---

## 🔧 Prerequisites

- Java 17 (JDK)
- Maven (or use the included Maven wrapper)
- PostgreSQL (defaults in `application.properties`):
  - URL: `jdbc:postgresql://localhost:5432/UrlShorten`
  - username: `postgres`
  - password: `root`

> You can change database settings in `src/main/resources/application.properties`.

---

## ⚡ Quick start (Windows)

1. Create the database (example using psql):

```bash
psql -U postgres -c "CREATE DATABASE \"UrlShorten\";"
```

2. Build the project using the Maven wrapper:

```powershell
.\mvnw.cmd clean package
```

3. Run the application:

```powershell
# using the wrapper
.\mvnw.cmd spring-boot:run

# or run the packaged jar
java -jar target\URLShorten-0.0.1-SNAPSHOT.jar
```

---

## 📡 API Endpoints

- **GET** `/getCode`
  - Description: Generates and stores a short code for the provided original URL.
  - Note: This endpoint accepts a JSON request body with the `originalUrl` field.
  - Request example (curl):

```bash
curl -X GET \
  -H "Content-Type: application/json" \
  -d '{"originalUrl": "https://example.com"}' \
  http://localhost:8081/getCode
```

  - Response: a shortened URL string like `http://localhost/8081/u/<code>` (use the returned code to redirect).

- **GET** `/u/{code}`
  - Description: Redirects (HTTP 302) to the original URL stored for the code.
  - Example:

```bash
curl -i http://localhost:8081/u/abc123
```

---

## 🧪 Tests

Run unit tests:

```powershell
.\mvnw.cmd test
```

---

## 💡 Notes & Improvements

- The `/getCode` endpoint currently uses GET with a request body (non-standard); a POST would be more appropriate.
- Default DB credentials are set in `application.properties` — change these for production.

---

## 🤝 Contributing

Contributions welcome — open a PR or raise an issue describing your change.

---

## 📜 License

No license specified. Add a `LICENSE` file if you want to publish under an open-source license.
