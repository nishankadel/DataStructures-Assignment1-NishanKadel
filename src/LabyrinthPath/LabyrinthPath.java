package LabyrinthPath;

class Node {
    String location;
    Node next;

    Node(String location) {
        this.location = location;
        this.next = null;
    }
}

//LabyrinthPath class using singly linked list
public class LabyrinthPath {
 private Node head;  // Head node representing the start of the path
 private Node tail;  // Tail node representing the last visited location

 // Constructor to initialize the labyrinth path
 public LabyrinthPath() {
     this.head = null;
     this.tail = null;
 }

 // Method to add a new location to the path
 public void addLocation(String location) {
     Node newNode = new Node(location);
     if (head == null) {
         head = newNode; // If the list is empty, the new node is both head and tail
         tail = head;
     } else {
         tail.next = newNode; // Add new node at the end of the list
         tail = newNode;
     }
     System.out.println(location + " added to the path.");
 }

 // Method to remove the last visited location
 public void removeLastLocation() {
     if (head == null) {
         System.out.println("No locations to remove.");
         return;
     }
     if (head == tail) {
         System.out.println(head.location + " removed from the path.");
         head = tail = null; // If only one location, remove it
         return;
     }

     Node current = head;
     while (current.next != tail) {  // Traverse to the second last node
         current = current.next;
     }

     System.out.println(tail.location + " removed from the path.");
     current.next = null; // Remove the last node
     tail = current;      // Update tail to the new last node
 }

 // Method to check if the path contains a loop
 public boolean hasLoop() {
     if (head == null) return false;

     Node slow = head;
     Node fast = head;

     // Use two pointers: slow moves one step, fast moves two steps
     while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;

         // If the two pointers meet, there's a loop
         if (slow == fast) {
             return true;
         }
     }

     return false;
 }

 // Method to print the entire path
 public void printPath() {
     if (head == null) {
         System.out.println("The path is empty.");
         return;
     }

     Node current = head;
     System.out.print("Path: ");
     while (current != null) {
         System.out.print(current.location);
         if (current.next != null) {
             System.out.print(" -> ");
         }
         current = current.next;
     }
     System.out.println();
 }
    public static void main(String[] args) {
        LabyrinthPath labyrinthPath = new LabyrinthPath();
        labyrinthPath.addLocation("Entrance");
        labyrinthPath.addLocation("Hallway");
        labyrinthPath.addLocation("Entrance");
        labyrinthPath.addLocation("Hallway");
        labyrinthPath.addLocation("Entrance");
        labyrinthPath.addLocation("Room 1");
        labyrinthPath.printPath();

        labyrinthPath.removeLastLocation();
        labyrinthPath.printPath();

        System.out.println("Contains loop: " + labyrinthPath.hasLoop());
    }
}
