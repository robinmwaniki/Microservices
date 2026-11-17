# Library Microservices

A learning project that separates a library domain into independently runnable Spring Boot services. The repository contains a book service, a student service, and a Eureka discovery server.

## Services

| Service | Responsibility |
| --- | --- |
| `book-service` | Exposes book-related REST endpoints and persists book records. |
| `student-service` | Provides student-related functionality and communicates with other services. |
| `discovery-server` | Provides Eureka service registration and discovery. |

The services use Spring Boot and Spring Cloud components. The student service includes OpenFeign and Eureka client dependencies; the book service also registers with Eureka.

## Technology stack

- Java 21
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud OpenFeign
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Prerequisites

- JDK 21
- Maven (or each service's Maven Wrapper)
- PostgreSQL configured for the services

## Getting started

Clone the repository:
```bash
git clone https://github.com/robinmwaniki/Microservices.git
cd Microservices
```

Each service is a separate Maven application. Configure its datasource and service-discovery settings in its own `src/main/resources/application.properties` or YAML configuration before starting it.

Start the discovery server first, then start the book and student services so they can register with Eureka. From each service directory, run:
```bash
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd spring-boot:run`.

## Build and test

Run the Maven build from each service directory:
```bash
./mvnw clean verify
```

## Repository layout

```text
Microservices/
├── book-service/
├── student-service/
└── discovery-server/
```

## Configuration

Ports, database credentials, and Eureka URLs are service-specific. Check each service's configuration before running the system. Do not commit local credentials.

## License

No license file is currently documented in this repository.