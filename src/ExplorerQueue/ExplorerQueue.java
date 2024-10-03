package ExplorerQueue;

public class ExplorerQueue {
    private String[] queue; // Array to store the explorers
    private int front;      // Index of the front of the queue
    private int rear;       // Index of the rear of the queue
    private int size;       // Current number of explorers in the queue
    private int capacity;   // Maximum capacity of the queue

    // Constructor to initialize the queue with a specified capacity
    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Method to enqueue a new explorer
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot add " + explorer);
            return;
        }

        // Increment rear in circular fashion
        rear = (rear + 1) % capacity;
        queue[rear] = explorer;
        size++;
        System.out.println(explorer + " has joined the queue.");
    }

    // Method to dequeue an explorer
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer to enter the temple.");
            return null;
        }

        String explorer = queue[front];
        front = (front + 1) % capacity; // Move front in circular fashion
        size--;
        System.out.println(explorer + " has entered the temple.");
        return explorer;
    }

    // Method to display the next explorer in line (peek)
    public String nextExplorer() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer in line.");
            return null;
        }
        System.out.println("Next explorer in line is: " + queue[front]);
        return queue[front];
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        ExplorerQueue queue = new ExplorerQueue(3); // Create a queue with capacity of 3

        // Enqueue explorers
        queue.enqueue("Explorer A");
        queue.enqueue("Explorer B");
        queue.enqueue("Explorer C");

        // Try to enqueue when the queue is full
        queue.enqueue("Explorer D");

        // Peek at the next explorer in line
        queue.nextExplorer();

        // Dequeue explorers
        queue.dequeue();
        queue.dequeue();

        // Check the next explorer
        queue.nextExplorer();

        // Dequeue the last explorer and check the empty condition
        queue.dequeue();
        queue.nextExplorer();

        // Try to dequeue from an empty queue
        queue.dequeue();
    }
}

