# Spring URL Shortener

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)
![Redis](https://img.shields.io/badge/Redis-7-red.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

A robust and scalable URL shortening service built with Spring Boot. This application provides a RESTful API to create short, unique aliases for long URLs and redirects users to the original URL when the short link is accessed. It leverages Redis for high-performance caching of frequently accessed URLs and PostgreSQL as the persistent data store.

---

## 🚀 Features

* **Shorten URLs:** Create a unique, short ID for any long URL.
* **Redirection:** Automatically redirects the short URL to its original destination.
* **High-Performance Caching:** Utilizes Redis to cache popular links, reducing database load and ensuring fast redirect times.
* **Persistent Storage:** Uses PostgreSQL to reliably store all URL mappings.
* **RESTful API:** A clean and simple API for interacting with the service.
* **Interactive API Documentation:** Comes with Swagger UI for easy exploration and testing of API endpoints.

---

## 🛠️ Tech Stack

| Technology | Purpose |
| :--- | :--- |
| **Java 17** | Core programming language |
| **Spring Boot 3** | Application framework |
| **Spring Data JPA**| Database interaction |
| **Spring Data Redis** | Caching integration |
| **PostgreSQL** | Primary relational database |
| **Redis** | In-memory cache for fast lookups |
| **Maven** | Dependency management and build tool |
| **Docker & Docker Compose**| Containerization for easy setup |
| **Springdoc OpenAPI (Swagger)** | API documentation |

---

## ⚙️ Getting Started

Follow these instructions to get a local copy up and running for development and testing.

### Prerequisites

Make sure you have the following software installed on your machine:

* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or later
* [Apache Maven](https://maven.apache.org/download.cgi)
* [Docker](https://www.docker.com/products/docker-desktop/) and Docker Compose
* A Git client

### Installation & Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/lwandokasuba/spring-url-shortener.git](https://github.com/lwandokasuba/spring-url-shortener.git)
    cd spring-url-shortener
    ```

2.  **Set up the Environment with Docker Compose:**
    We use Docker to run PostgreSQL and Redis instances. A `docker-compose.yml` file is provided for your convenience.

    Start the containers:
    ```bash
    docker-compose up -d
    ```
    This command will pull the required images and start PostgreSQL and Redis containers in the background.

3.  **Configure the Application:**
    The application connects to the database and cache using credentials defined in `src/main/resources/application.properties`. A template is provided.

    The default configuration should work with the `docker-compose.yml` file out of the box.

    ```properties
    # application.properties

    # Server Port
    server.port=8080

    # PostgreSQL Database Configuration
    spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener_db
    spring.datasource.username=user
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

    # Redis Cache Configuration
    spring.redis.host=localhost
    spring.redis.port=6379
    ```

4.  **Run the Spring Boot Application:**
    You can run the application using the Maven wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will start and connect to the services running in Docker.

You should see output indicating that the application has started successfully on port `8080`.

---

##  usage Usage & API Documentation

The primary way to interact with the service is through its REST API. For a complete, interactive guide to all available endpoints, please use the Swagger UI.

### Swagger API Documentation

Once the application is running, you can access the interactive Swagger documentation here:

➡️ **http://localhost:8080/swagger-ui/index.html**

From the Swagger UI, you can view all endpoints, see request/response models, and execute API calls directly from your browser.

### Example API Calls

Here are a couple of `cURL` examples for common operations.

#### 1. Shorten a URL

Send a `POST` request with the long URL in the body.

* **Endpoint:** `POST /api/v1/shorten`
* **Request Body:**
    ```json
    {
      "longUrl": "[https://www.very-long-and-complex-url.com/with/some/path?and_query_params=true](https://www.very-long-and-complex-url.com/with/some/path?and_query_params=true)"
    }
    ```

* **cURL Command:**
    ```bash
    curl -X POST http://localhost:8080/api/v1/shorten \
    -H "Content-Type: application/json" \
    -d '{"longUrl": "[https://www.google.com/search?q=spring+boot](https://www.google.com/search?q=spring+boot)"}'
    ```

* **Successful Response (200 OK):**
    ```json
    {
      "shortUrl": "http://localhost:8080/r/aF3bC9dE"
    }
    ```

#### 2. Redirect to Original URL

To use the short link, simply open it in your browser or use a `cURL` command with the `-L` flag to follow redirects.

* **Endpoint:** `GET /r/{shortKey}`
* **Example:** `http://localhost:8080/r/aF3bC9dE`

* **cURL Command:**
    ```bash
    curl -L http://localhost:8080/r/aF3bC9dE
    ```
    This will result in a `302 Found` redirect to the original long URL.

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

---

## 📜 License

Distributed under the MIT License. See `LICENSE` for more information.

---

## 📞 Contact

Lwando Kasuba - [@lwando_kasuba](https://twitter.com/lwando_kasuba) - lwandokasuba@email.com

Project Link: [https://github.com/lwandokasuba/spring-url-shortener](https://github.com/lwandokasuba/spring-url-shortener)
