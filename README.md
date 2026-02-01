# Employee Management System (Java) 🚀

This is a Week 4 Capstone Project for my Java Development Internship. The system handles employee data using advanced Java concepts like the Collections Framework and Object Serialization for persistent storage.

## 📌 Key Features
- **Full CRUD Operations**: Add, View, and Search employees easily.
- **Fast Lookups**: Optimized searching using `HashMap` for $O(1)$ time complexity.
- **Data Persistence**: Uses File I/O (Serialization) to save data in `.dat` files, so data isn't lost after closing the program.
- **Reporting**: Generates salary statistics (Total payout, Average salary, etc.).
- **Input Validation**: Robust error handling using `try-catch` blocks for data integrity.

## 🛠️ Tech Stack
- **Language**: Java 17+
- **Concepts**: 
  - Java Collections (`ArrayList`, `HashMap`)
  - File Handling (`ObjectOutputStream`, `ObjectInputStream`)
  - Exception Handling
  - Object-Oriented Programming (OOPS)

## 📂 Project Structure
```text
├── src/
│   ├── Employee.java                # Data model class (Serializable)
│   └── EmployeeManagementSystem.java # Main logic and UI menu
|
└── README.md                        # Documentation
