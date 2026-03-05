# LogisticsHub API

A robust, production-ready Spring Boot backend designed for efficient warehouse and inventory management. This project demonstrates a complete three-tier architecture with a focus on data integrity, containerization, and professional API standards.

## 🚀 Key Features

- **Transactional Stock Movement**: Implemented `@Transactional` logic to ensure "all-or-nothing" stock transfers between warehouses, preventing data loss.
- **Containerized Infrastructure**: Fully dockerized environment using Docker Compose for seamless database and application orchestration.
- **Professional API Standards**: Automated documentation via Swagger/OpenAPI and optimized data fetching through Pagination and Sorting.
- **Data Integrity**: Used JPA/Hibernate with `@JsonIgnoreProperties` to manage complex bi-directional relationships without infinite recursion.

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 3.2.4
- **Database**: PostgreSQL
- **DevOps**: Docker, Docker Compose
- **Security**: Spring Security (Basic Auth / PermitAll for Dev)
- **Documentation**: Springdoc-OpenAPI (Swagger UI)

## 📥 Getting Started

### Prerequisites

- Docker & Docker Desktop
- Java 21 JDK
- Maven

### Installation & Setup

1. Clone the repository:

```bash
git clone https://github.com/your-username/LogisticsHub-API.git
cd LogisticsHub-API
```

2. Build the application:

```bash
./mvnw clean package -DskipTests
```

3. Launch the stack:

```bash
docker-compose up -d --build
```

## API Endpoints (Swagger UI)
Once the application is running, access the interactive documentation at: <br>
http://localhost:8080/swagger-ui/index.html <br>

| Method | Endpoint |	Description |
| :--- | :----: | ---: |
| GET | /api/inventory/all | Fetch all inventory items (Global view) |
| GET | /api/inventory/paginated | Fetch inventory with pagination support |
| POST | /api/inventory/add | Add initial stock to a specific warehouse |
| POST | /api/inventory/transfer | Move stock between two warehouses atomically |

## Infrastructure Configuration
```
App Port: 8080
Internal DB Port: 5432
External DB Port (for Mac/TablePlus): 5435
```

## License
Distributed under the MIT License.
