## Getting Started

Assume you already have Docker Compose installed. See https://docs.docker.com/compose/install/.

To install this application, run the following commands:

```
git clone https://github.com/residwi/simple-microservices-demo.git
cd simple-microservices-demo
```

Run the following command to create Docker containers for all your apps.

`./mvnw clean install`

Then you can start the application using Docker Compose:

`docker-compose up -d`

After everything starts, you can open your browser to http://localhost:8888.

## Services

You can check all services that registers to service-discovery at http://localhost:8761

- **api-gateway**: Netflix Zuul. It’s a proxy, gateway, an intermediate layer between the client and the services.
- **config-server**: A service for manage a configuration every service.
- **customer-service**: A persistence service for manage customers.
- **transaction-service**: A persistence service for transaction.
- **product-service**: A persistence service for manage products.
- **service-discovery**: Eureka Server for service discovery.

## API Endpoints

### Customer Service

| Method | URI                   | Description               |
| :----- | :-------------------- | :------------------------ |
| `GET`  | `/api/customers`      | List all customers        |
| `GET`  | `/api/customers/{id}` | Get customer detail by id |
| `POST` | `/api/customers`      | Create customer           |
| `PUT`  | `/api/customers/{id}` | Update customer           |

#### Request body

```http
POST /api/customers
```

```json
{
    "name":"string",
    "address":"string"
}
```

```http
PUT /api/customers/{id}
```

```json
{
    "name":"string",
    "address":"string"
}
```

### Product Service

| Method | URI                  | Description        |
| :----- | :------------------- | :----------------- |
| `GET`  | `/api/products`      | List all products  |
| `GET`  | `/api/products/{id}` | Get product detail |
| `POST` | `/api/products`      | Create product     |
| `PUT`  | `/api/products/{id}` | Update product     |

#### Request body

```http
POST /api/products
```

```json
{
    "name":"string",
    "code":"string",
    "price":"integer",
    "stock":"integer"
}
```

```http
PUT /api/products/{id}
```

```json
{
    "name":"string",
    "price":"integer",
    "stock":"integer"
}
```

### Transaction Service

| Method | URI                      | Description            |
| :----- | :----------------------- | :--------------------- |
| `GET`  | `/api/transactions`      | List all transactions  |
| `GET`  | `/api/transactions/{id}` | Get transaction detail |
| `POST` | `/api/transactions`      | Create transaction     |

#### Request body

```http
POST /api/transactions
```

```json
{
    "code":"string",
    "customerId":"string",
    "productId":"integer",
    "quantity":"integer"
}
```