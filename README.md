# Expence Tracker App

Expence Tracker App is a RESTful API application developed to track and manage personal expenses. Built with the Spring Boot framework, this application allows users to create categories, record their expenses, update them, and delete them as needed.

## Features

### Category Management

- List all categories
- Get category by ID
- Create a new category
- Update an existing category
- Delete a category

### Expense Management

- List all expenses
- Get expense by ID
- Create a new expense
- Update an existing expense
- Delete an expense

## API Endpoints

### Category Operations

#### Get All Categories

```http
GET /api/categories/getAllCategory
```

#### Get Category by ID

```http
GET /api/categories/getByIdCategory?id={categoryId}
```

#### Create a New Category

```http
POST /api/categories/createCategory
Content-Type: application/json

{
    "name": "Food",
    "description": "Grocery and meal expenses"
}
```

#### Update a Category

```http
PUT /api/categories/updateCategory/{id}
Content-Type: application/json

{
    "name": "New Category Name",
    "description": "Updated description"
}
```

#### Delete a Category

```http
DELETE /api/categories/deleteCategory/{id}
```

### Expense Operations

#### Get All Expenses

```http
GET /api/expencies/getAllExpencies
```

#### Get Expense by ID

```http
GET /api/expencies/getByIdExpence/{id}
```

#### Create a New Expense

```http
POST /api/expencies/createExpence
Content-Type: application/json

{
    "amount": 150.00,
    "description": "Dinner",
    "categoryId": 1,
    "date": "2025-03-16"
}
```

#### Update an Expense

```http
PUT /api/expencies/updateExpence/{id}
Content-Type: application/json

{
    "amount": 200.00,
    "description": "Updated expense",
    "categoryId": 1,
    "date": "2025-03-17"
}
```

#### Delete an Expense

```http
DELETE /api/expencies/deleteExpence/{id}
```

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**

---

### Installation & Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/expence-tracker-app.git
   ```
2. Navigate to the project directory:
   ```sh
   cd expence-tracker-app
   ```
3. Build and run the application using Maven:
   ```sh
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080/`.

---

### Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request.

---

### License

This project is licensed under the MIT License.

