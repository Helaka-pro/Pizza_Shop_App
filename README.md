# 🍕 Pizza Sri Lanka - Restaurant Ordering System

## 1. Introduction

This project is a Java console based restaurant ordering system created for a pizza shop in Sri Lanka. The system is designed to simulate how a real restaurant manages its menu and processes customer orders. It allows both manager and customer roles to interact with the system in a simple and structured way.

The main goal of this project is to apply object oriented programming concepts such as inheritance, polymorphism, interfaces, and collections to a real world scenario.

---

## 2. Technologies I Used

* Java (JDK)
* Object Oriented Programming concepts
* ArrayList and HashMap collections
* Comparator for sorting
* Console based user interface

---

## 3. Features

### 👨‍💼 Manager Features

* Add new menu items (Pizza, Side, Drink)
* Remove items using item ID
* View full menu
* Search menu items by name or ID
* Sort menu items by price and name
* View all customer orders
* Update order status (Preparing, Ready, Completed)

### 🧑‍🍳 Customer Features

* View menu
* Search items
* Sort items by price or name
* Create an order
* Add multiple items with quantity
* Add special notes
* Select payment method (Cash or Card)
* View order summary with total and discount

---

## 4. Keyboard Shortcuts

Since this is a console application, the system uses number based inputs instead of keyboard shortcuts.

Examples:

* Press **1** for Manager
* Press **2** for Customer
* Press **3** to Exit
* Menu options are selected using numbers shown on screen

---

## 5. Process - How I Built It

I started by identifying the main entities in the system such as MenuItem, Pizza, Side, Drink, Order, and Menu. Then I created a class structure using inheritance where Pizza, Side, and Drink extend MenuItem.

After that I implemented the core features step by step:

* Menu management using ArrayList and HashMap
* Order creation with Order and OrderItem classes
* Enums for fixed values like size, crust, payment method, and order status
* Sorting using Comparator for better performance and clean code
* User interaction using Scanner

Finally I tested each feature and improved the structure of the code.

---

## 6. What I Learnt From This

* How to apply object oriented programming concepts in a real system
* The difference between List and Map and when to use them
* How inheritance and polymorphism reduce code duplication
* How to use Comparator for sorting instead of manual loops
* How to design a system step by step from a real world scenario
* Importance of clean and structured code

---

## 7. How It Could Be Improved

* Add a graphical user interface instead of console
* Improve validation for user inputs
* Store data in a database instead of memory
* Add login system for manager and staff
* Improve order tracking with timestamps
* Reduce code repetition in the main method

---

## 8. How to Run the Project

### Step 1

Download or clone the repository

### Step 2

Open the project in any Java IDE (IntelliJ, Eclipse, VS Code)

### Step 3

Compile the program

### Step 4

Run the main class:

```
PizzaShopApp.java
```

### Step 5

Follow the on screen instructions to interact with the system

---

## 📌 Note

This project was developed for academic purposes to demonstrate understanding of object oriented programming concepts.
