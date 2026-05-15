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
<img width="328" height="176" alt="Picture 1" src="https://github.com/user-attachments/assets/d41b7115-1350-400a-9acb-48257d740b3a" />
<img width="359" height="425" alt="Picture 2" src="https://github.com/user-attachments/assets/14a5de1a-57d5-4598-9de3-18765bc6fe1e" />
<img width="452" height="609" alt="Picture 3" src="https://github.com/user-attachments/assets/38d4f362-e9c1-4f4d-8be9-d5fa22595b28" />
<img width="452" height="318" alt="Picture 4" src="https://github.com/user-attachments/assets/88b2162b-171e-473a-b06a-9881d636a6f7" />
<img width="500" height="633" alt="Picture 5" src="https://github.com/user-attachments/assets/c8145659-8eab-4c6e-b6f2-8383db55bda1" />
<img width="439" height="667" alt="Picture 6" src="https://github.com/user-attachments/assets/ac43bd85-6ebd-4a9d-8bc6-4fb32005fa84" />
<img width="383" height="328" alt="Picture 7" src="https://github.com/user-attachments/assets/7177ffcf-b150-4467-b38e-7b459747c12e" />
<img width="524" height="449" alt="Picture 9" src="https://github.com/user-attachments/assets/b9687a65-1dee-4524-90c4-84519a9abd5c" />
<img width="427" height="307" alt="Picture 8" src="https://github.com/user-attachments/assets/6c716a70-3fa3-4e06-9545-957c62e67bc4" />
<img width="524" height="471" alt="Picture 10" src="https://github.com/user-attachments/assets/53164680-214d-4b6f-ad6f-0c84af42acaa" />
<img width="524" height="585" alt="Picture 11" src="https://github.com/user-attachments/assets/f3bd45fb-1d33-4080-8ad9-4c94f6f9a877" />
<img width="524" height="513" alt="Picture 12" src="https://github.com/user-attachments/assets/7afc25d5-f6ba-4737-bffe-79648c6063a9" />







