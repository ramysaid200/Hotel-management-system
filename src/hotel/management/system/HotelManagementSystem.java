package hotel.management.system;

        import java.util.Scanner;
/*Authored by: Ahmed Abdel Razek(ID:232903959)
               David George Helmy(ID:231903654)
               Ramy Saeed Eliwa (ID:231903795)
               Youssef Amer Sayed(ID:231903616)
*/
//WELCOME TO OUR PROJECTخش برجلك اليمين 

public class HotelManagementSystem {

    
    public static void main(String[] args) {
        
        Hotel hotel = new Hotel(50); // 50 rooms
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nHotel Management System");
        System.out.println("1. Reserve a room");
        System.out.println("2. Checkout a room");
        System.out.println("3. Display all rooms");
        System.out.println("4. Undo last reservation");
        System.out.println("5. Request room service");
        System.out.println("6. Process next room service request");
        System.out.println("7. Display all pending room service requests");
        System.out.println("8. View reservation history (Manager only)");
        System.out.println("9. View most reserved room (Manager only)");
        System.out.println("10. Search for a specific room (Binary Search)");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();
                    hotel.reserveRoomByNumber(roomNumber, days);
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    roomNumber = scanner.nextInt();
                    hotel.checkoutRoom(roomNumber);
                    break;
                case 3:
                    hotel.displayRooms();
                    break;    
                case 4:
                    hotel.undoLastReservation();
                    break;
                 case 5:
                    System.out.print("Enter room number to request room service: ");
                    int roomForService = scanner.nextInt();
                    hotel.requestRoomService(roomForService);
                    break;

                case 6:
                    hotel.processNextRoomService();
                    break;

                case 7:
                    hotel.displayRoomServiceRequests();
                    break;    
                case 8:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    hotel.viewHistory(username, password);
                    break;
                case 9:
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    System.out.print("Enter password: ");
                    password = scanner.next();
                    hotel.viewMostReservedRoom(username, password);
                    break;
                    case 10:
                    System.out.print("Enter room number to search: ");
                    int searchRoomNumber = scanner.nextInt();
                    hotel.searchRoomByBinarySearch(searchRoomNumber);
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
//Used it in (Undo last reservation,View reservation history)
class Stackx {
    private int[] stack;
    private int top;
    private int maxSize;

    public Stackx(int size) {
        stack = new int[size];
        top = -1;
        maxSize = size;
    }

    public void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full.");
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}


// Used it in room services
class Queuex {
    private int[] queue;
    private int front;
    private int rear;
    private int maxSize;
    private int size;

    public Queuex(int maxSize) {
        this.queue = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.size = 0;
    }

   
    public void enqueue(int roomNumber) {
        if (size == maxSize) {
            System.out.println("Room service queue is full.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = roomNumber;
        size++;
        System.out.println("Added room " + roomNumber + " to the room service queue.");
    }

    
    public int dequeue() {
        if (size == 0) {
            System.out.println("Room service queue is empty.");
            return -1;
        }
        int roomNumber = queue[front];
        front = (front + 1) % maxSize;
        size--;
        return roomNumber;
    }

    
    public void displayQueue() {
        if (size == 0) {
            System.out.println("Room service queue is empty.");
            return;
        }
        System.out.println("Room service queue:");
        for (int i = 0; i < size; i++) {
            System.out.println("Room " + queue[(front + i) % maxSize]);
        }
    }

  
    public boolean isEmpty() {
        return size == 0;
    }
}


class Node {
    Room room;
    Node next;
    Node prev;

    public Node(Room room) {
        this.room = room;
        this.next = null;
        this.prev = null;
    }
}
//Rooms
class DoublyLinkedList {
    Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public void addRoom(Room room) {
        Node newNode = new Node(room);
        if (head == null) { // First node
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    
    public Room findRoom(int roomNumber) {
        Node current = head;
        while (current != null) {
            if (current.room.roomNumber == roomNumber) {
                return current.room;
            }
            current = current.next;
        }
        return null; // Room not found
    }

   
    public void displayRooms() {
        Node current = head;
        while (current != null) {
            Room room = current.room;
            System.out.println("Room " + room.roomNumber + " - " + (room.isOccupied ? "Occupied" : "Available") +
                    " - Price: " + room.currentPrice + " pounds");
            current = current.next;
        }
    }
}



    
class Room {
    int roomNumber;
    boolean isOccupied;
    int basePrice;
    int currentPrice;
    int daysReserved;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.basePrice = 1200; 
        this.currentPrice = basePrice; 
        this.daysReserved = 0;
    }

    public void reserve(int days) {
        this.isOccupied = true;
        this.daysReserved = days;
    }

    public void checkout() {
        this.isOccupied = false;
        this.daysReserved = 0;
    }

    public int calculateBill() {
        return this.currentPrice * this.daysReserved;
    }
}

//Tracks the reserved rooms and  how many times each room has been reserved
class History {
    private Stackx reservationHistory; 
    private int[] reservationCount; 

    public History(int totalRooms) {
        reservationHistory = new Stackx(100); 
        reservationCount = new int[totalRooms + 1]; 
    }


    public void logReservation(int roomNumber) {
        reservationHistory.push(roomNumber);
        reservationCount[roomNumber]++;
    }

    
    public void displayHistory() {
        System.out.println("Reservation History (most recent first):");
        while (!reservationHistory.isEmpty()) {
            System.out.println("Room " + reservationHistory.pop());
        }
    }

    public int getMostReservedRoom() {
        int mostReservedRoom = -1;
        int maxReservations = 0;
        for (int i = 1; i < reservationCount.length; i++) {
            if (reservationCount[i] > maxReservations) {
                mostReservedRoom = i;
                maxReservations = reservationCount[i];
            }
        }
        return mostReservedRoom;
    }
}
    

class Hotel {
    private DoublyLinkedList roomsList ;
    private Stackx undoStack;
    private History history;
    private String managerUsername;
    private String managerPassword;

    public Hotel(int totalRooms) {
        roomsList = new DoublyLinkedList();
        undoStack = new Stackx(totalRooms);
        history = new History(totalRooms);

        //Create the rooms
        for (int i = 1; i <= totalRooms; i++) {
            Room room = new Room(i); 
            roomsList.addRoom(room); 
        }

      
        managerUsername = "admin";
        managerPassword = "password";
    }

    public void reserveRoomByNumber(int roomNumber, int days) {
        Room room = roomsList.findRoom(roomNumber); 
        if (room == null) {
            System.out.println("Invalid room number.");
            return;
        }

        if (room.isOccupied) {
            System.out.println("Room " + roomNumber + " is already occupied.");
        } else {
            room.reserve(days);
            undoStack.push(room.roomNumber);
            history.logReservation(room.roomNumber);

           
            int mostReservedRoom = history.getMostReservedRoom();
            if (room.roomNumber == mostReservedRoom) {
                room.currentPrice = (int) (room.basePrice * 1.2); // Increase price by 20%
            }

            System.out.println("Room " + room.roomNumber + " reserved for " + days + " days.");
        }
    }
    
private Queuex roomServiceQueue = new Queuex(50); 


public void requestRoomService(int roomNumber) {
    Room room = roomsList.findRoom(roomNumber); 
    if (room == null) {
        System.out.println("Invalid room number.");
        return;
    }
    if (!room.isOccupied) {
        System.out.println("Room " + roomNumber + " is not occupied. Room service cannot be requested.");
    } else {
        roomServiceQueue.enqueue(roomNumber); 
        System.out.println("Room service requested for room " + roomNumber + ".");
    }
}


public void processNextRoomService() {
    if (roomServiceQueue.isEmpty()) {
        System.out.println("No pending room service requests.");
    } else {
        int roomNumber = roomServiceQueue.dequeue();
        System.out.println("Processing room service for room " + roomNumber + ".");
    }
}


public void displayRoomServiceRequests() {
    roomServiceQueue.displayQueue();
}


    public void checkoutRoom(int roomNumber) {
        Room room = roomsList.findRoom(roomNumber);
        if (room == null) {
            System.out.println("Invalid room number.");
            return;
        }

        if (!room.isOccupied) {
            System.out.println("Room " + roomNumber + " is not occupied.");
        } else {
            int bill = room.calculateBill(); // Calculate the total price
            room.checkout(); // Reset the room
            System.out.println("Room " + roomNumber + " checked out. Total bill: " + bill + " pounds.");
        }
    }

    public void undoLastReservation() {
        int lastReservedRoom = undoStack.pop();
        if (lastReservedRoom == -1) {
            System.out.println("No reservations to undo.");
            return;
        }

        Room room = roomsList.findRoom(lastReservedRoom);
        if (room != null && room.isOccupied) {
            room.checkout();
            System.out.println("Last reservation for room " + lastReservedRoom + " has been undone.");
        }
    }
    /*The following function make the following:
    Extract all rooms into an array
    Sort the rooms by roomNumber using a recursive Bubble Sort
    Perform binary search
    */
public void searchRoomByBinarySearch(int roomNumber) {
  
    Room[] roomArray = extractRoomsToArray();

     
    sortRoomsByRecursion(roomArray, roomArray.length);

    
    int left = 0, right = roomArray.length - 1;
    boolean found = false;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        Room midRoom = roomArray[mid];

        if (midRoom.roomNumber == roomNumber) {
            found = true;
            System.out.println("Room " + roomNumber + " is " +
                    (midRoom.isOccupied ? "occupied." : "available."));
            break;
        } else if (midRoom.roomNumber < roomNumber) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

   
    if (!found) {
        System.out.println("Room " + roomNumber + " does not exist.");
    }
}


private Room[] extractRoomsToArray() {
    int size = countRooms();
    Room[] roomArray = new Room[size];

    Node current = roomsList.head; 
    int index = 0;
    while (current != null) {
        roomArray[index++] = current.room;
        current = current.next;
    }

    return roomArray;
}


private int countRooms() {
    Node current = roomsList.head;
    int count = 0;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
}


private void sortRoomsByRecursion(Room[] roomArray, int n) {
    if (n <= 1) {
        return; 
    }


    for (int i = 0; i < n - 1; i++) {
        if (roomArray[i].roomNumber > roomArray[i + 1].roomNumber) {
            
            Room temp = roomArray[i];
            roomArray[i] = roomArray[i + 1];
            roomArray[i + 1] = temp;
        }
    }


    sortRoomsByRecursion(roomArray, n - 1);
}

    public void displayRooms() {
        roomsList.displayRooms(); 
    }

    public void viewHistory(String username, String password) {
        if (authenticate(username, password)) {
            history.displayHistory();
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    public void viewMostReservedRoom(String username, String password) {
        if (authenticate(username, password)) {
            int mostReservedRoom = history.getMostReservedRoom();
            if (mostReservedRoom == -1) {
                System.out.println("No reservations have been made yet.");
            } else {
                System.out.println("Most reserved room: Room " + mostReservedRoom);
            }
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    private boolean authenticate(String username, String password) {
        return managerUsername.equals(username) && managerPassword.equals(password);
    }
}