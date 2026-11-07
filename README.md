# Restaurant Management System

A console-based Restaurant Management System built using Java. This project demonstrates all four major Object-Oriented Programming (OOP) concepts through food menu management and customer order operations.

## About

This project allows users to view the restaurant food menu, place orders, cancel orders, and view customer order details.

The system provides four predefined food items with different prices and available quantities.

Users can order multiple quantities of a food item, and the system automatically calculates the total bill and updates the available quantity.

## Features

- View restaurant food menu
- Place food orders
- Cancel existing orders
- View customer orders
- Order multiple quantities
- Automatically calculate total bills
- Update available food quantities after ordering
- Restore food quantities after order cancellation
- Generate unique order IDs
- Validate food IDs
- Check available food quantities
- Handle invalid menu choices

## OOP Concepts Used

### 1. Encapsulation
Private attributes are used in the `Food` and `Order` classes. Getters provide access to these attributes.

### 2. Inheritance
The `RestaurantOrder` class extends the abstract `Order` class using the `extends` keyword.

### 3. Polymorphism
Method overriding is used in the `RestaurantOrder` class to provide implementations of `calculateTotalBill()` and `displayOrder()`.

### 4. Abstraction
The `Order` class is declared as an abstract class and contains abstract methods.

## Other Java Concepts Practiced

- Classes and objects
- Constructors
- Getters
- `private` access modifier
- Abstract classes and methods
- `extends` keyword
- `super()` keyword
- `@Override` annotation
- `ArrayList`
- `HashMap`
- `Scanner`
- `switch` statements
- `while` loops
- Enhanced `for` loops
- Conditional statements
- Exception handling
- `Integer.parseInt()`
- `NumberFormatException`

## How It Works

### 1. View Food Menu
Displays all available food items with their IDs, names, prices, and available quantities.

### 2. Place Order
Allows the customer to select a food item, enter their name, and choose the required quantity. The system checks availability, calculates the total bill, and generates an order ID.

### 3. Cancel Order
Allows the customer to cancel an existing order using its order ID. The cancelled quantity is added back to the food item's available quantity.

### 4. View My Orders
Displays all current orders, including order ID, customer name, food item, quantity, and total bill.

## Available Food Items

| Food ID | Food Name | Price | Available Quantity |
|---|---|---|---|
| 1 | Burger | Rs. 500 | 20 |
| 2 | Pizza | Rs. 1,200 | 15 |
| 3 | Biryani | Rs. 350 | 25 |
| 4 | Sandwich | Rs. 400 | 20 |

## Menu Options

| Option | Function |
|---|---|
| 0 | Exit |
| 1 | View Food Menu |
| 2 | Place Order |
| 3 | Cancel Order |
| 4 | View My Orders |

## Bill Calculation

Total Bill = Food Price × Quantity

**Example:**

- Food Item = Pizza
- Price = Rs. 1,200
- Quantity = 2
- Total Bill = Rs. 2,400

## Data Structures Used

- **ArrayList:** Stores food menu items.
- **HashMap:** Stores customer orders using order IDs as keys.

## How to Run

1. Download or clone this repository.
2. Open the project folder in your code editor.
3. Make sure Java JDK is installed.
4. Open the terminal in the project folder.
5. Compile the program:

   ```bash
   javac Main.java
   ```

6. Run the program:

   ```bash
   java Main
   ```

## Data Storage

Food menu items and customer orders are stored in an `ArrayList` and a `HashMap`. All data is stored in memory and resets when the program restarts.

## Purpose

This project is designed to practice Java programming and all four major OOP concepts through a practical restaurant management application.

## Future Improvements

- Add more food items
- Add food categories
- Add customer contact information
- Add multiple food items to a single order
- Add payment processing
- Save orders using file handling
- Connect the system to a database
- Add a graphical user interface

## Author

Fatima Aziz

GitHub: [fatimaaziz27](https://github.com/fatimaaziz27)
