# 🏨 Hotel Management System

A console-based **Hotel Management System** built in Java, developed as a Data Structures & Algorithms course project. It demonstrates the practical application of core data structures — **Stack**, **Queue**, **Doubly Linked List** — and algorithms like **Binary Search** and **Recursive Bubble Sort**.

---

## 👥 Authors

| Name |
|------|
| Ahmed Abdel Razek | 
| David George Helmy | 
| Ramy Saeed Eliwa | 
| Youssef Amer Sayed | 

---

## 📋 Features

| # | Feature | Data Structure Used |
|---|---------|---------------------|
| 1 | **Reserve a Room** | Doubly Linked List + Stack (undo) |
| 2 | **Checkout a Room** | Doubly Linked List |
| 3 | **Display All Rooms** | Doubly Linked List |
| 4 | **Undo Last Reservation** | Stack |
| 5 | **Request Room Service** | Queue |
| 6 | **Process Next Room Service** | Queue (FIFO) |
| 7 | **Display Pending Service Requests** | Queue |
| 8 | **View Reservation History** *(Manager only)* | Stack |
| 9 | **View Most Reserved Room** *(Manager only)* | Stack + frequency array |
| 10 | **Search for a Room** | Binary Search + Recursive Bubble Sort |

---

## 🗂️ Data Structures Used

### 🔷 Doubly Linked List — Room Storage
All hotel rooms are stored in a **Doubly Linked List** (`DoublyLinkedList`). Each node holds a `Room` object and has pointers to both the next and previous nodes, enabling efficient traversal and insertion.

### 🔷 Stack (`Stackx`) — Undo & Reservation History
A custom array-based **Stack** is used in two places:
- **Undo Last Reservation**: The most recently reserved room is pushed onto the undo stack. Popping it reverts the reservation.
- **Reservation History** (Manager feature): All reserved room numbers are pushed onto the history stack for audit purposes.

### 🔷 Queue (`Queuex`) — Room Service Requests
A circular array-based **Queue** handles room service requests in **FIFO** order. Guests request service and it's processed one at a time.

### 🔷 Binary Search + Recursive Bubble Sort — Room Lookup
When searching for a room, the linked list is extracted into an array, sorted using **Recursive Bubble Sort**, and then searched using **Binary Search** for O(log n) lookup performance.

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- NetBeans IDE (recommended) or any Java-compatible IDE

### Run the Project

**Option 1 — NetBeans:**
1. Open NetBeans IDE
2. Go to `File → Open Project`
3. Navigate to the `JavaApplication5` folder and open it
4. Click the **Run** button (▶) or press `F6`

**Option 2 — Command Line:**
```bash
# Compile
javac -d out src/hotel/management/system/HotelManagementSystem.java

# Run
java -cp out hotel.management.system.HotelManagementSystem
```

---

## 🖥️ System Menu

```
Hotel Management System
1. Reserve a room
2. Checkout a room
3. Display all rooms
4. Undo last reservation
5. Request room service
6. Process next room service request
7. Display all pending room service requests
8. View reservation history (Manager only)
9. View most reserved room (Manager only)
10. Search for a specific room (Binary Search)
0. Exit
```

> **Manager Credentials:**
> - Username: `admin`
> - Password: `password`

---

## 💡 Key Design Decisions

- **Dynamic Pricing**: The most-reserved room automatically gets its price increased by 20% to reflect high demand.
- **Role-Based Access**: History and analytics features are gated behind manager authentication.
- **Custom Data Structures**: All data structures (Stack, Queue, Linked List) are implemented from scratch — no Java Collections Framework used — to demonstrate DSA concepts.

---

## 📁 Project Structure

```
JavaApplication5/
├── src/
│   └── hotel/
│       └── management/
│           └── system/
│               └── HotelManagementSystem.java   # All classes in one file
├── build/
├── dist/
├── nbproject/
├── build.xml
├── manifest.mf
└── README.md
```

---

## 📚 Course Context

- **Course**: Data Structures and Algorithms
- **Semester**: 5th Semester

---

## 📄 License

This project is for academic purposes only.
