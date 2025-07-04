# 💼 Hibernate CRUD Mini Project

A simple Java-based mini project that demonstrates **CRUD (Create, Read, Update, Delete)** operations using **Hibernate ORM** and **MySQL**.

---

## 🚀 Features

- Add a new Employee
- Get a specific Employee by ID
- Update an Employee's details
- Delete an Employee
- Retrieve all Employees
- Perform HQL-based bulk update and delete

---

## 🛠️ Tech Stack

- **Java 17+**
- **Hibernate 6**
- **MySQL**
- **JDBC Driver**
- **Maven** (for dependency management) or manual JARs if not using Maven
- **IDE:** Eclipse/IntelliJ

---

## 📁 Project Structure

src/
└── com/
└── demo/
└── Demo.java // Main class with all CRUD logic
└── model/
└── Employee.java // Entity class
hibernate.cfg.xml // Hibernate configuration
setting.xml // Optional persistence config if used
---

## 🧱 Database Table

Make sure your MySQL has this table:

```sql
CREATE DATABASE hibernate_crud;

USE hibernate_crud;

CREATE TABLE employee (
    empId INT PRIMARY KEY,
    name VARCHAR(50),
    dept VARCHAR(50),
    salary DOUBLE
);
