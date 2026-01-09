# 🔗 LinkForge

**LinkForge** is a backend URL shortener service built with **Spring Boot**, designed to demonstrate fast and secure redirection along with production-oriented backend design principles.

This project focuses on **correctness, security, and scalability**, rather than being a simple demo or tutorial application.

---

## ✨ Features

- Short URL generation with unique identifiers
- Fast HTTP redirection (`301 / 302`)
- Secure destination URL validation
- Protection against open redirect abuse
- Basic click tracking
- Graceful handling of invalid or expired links
- RESTful API design
- Clean, production-ready project structure

---

## 🛡️ Security Considerations

LinkForge includes essential security checks commonly required in production systems:

- Allows only valid `http` and `https` destination URLs
- Blocks dangerous URL schemes such as:
  - `javascript:`
  - `data:`
  - `file:`
- Prevents redirect loops and self-redirects
- Input validation to reduce abuse and phishing risks

These measures help prevent misuse of the service as a malicious redirect platform.

---

## 🏗️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2
- Maven

---

## 📐 High-Level Architecture

1. Client requests creation of a short URL
2. Server generates and stores a unique short code
3. Short code maps to the original destination URL
4. When accessed, the service:
   - Validates the request
   - Resolves the destination URL
   - Issues an HTTP redirect response
5. The browser automatically navigates to the target site

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Run Locally

```bash
git clone https://github.com/loharaniket/linkforge-springboot.git
cd linkforge-springboot
mvn spring-boot:run
