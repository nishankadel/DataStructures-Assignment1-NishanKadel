package ScrollStack;

//Node class to represent each scroll in the stack
class ScrollNode {
 String title;   // Scroll title
 ScrollNode next;  // Pointer to the next node

 // Constructor to create a new ScrollNode
 public ScrollNode(String title) {
     this.title = title;
     this.next = null;
 }
}

//ScrollStack class to manage the stack of scrolls
public class ScrollStack {
 private ScrollNode top;  // The top node in the stack

 // Constructor to initialize an empty stack
 public ScrollStack() {
     this.top = null;
 }

 // Method to push a new scroll onto the stack
 public void push(String title) {
     ScrollNode newNode = new ScrollNode(title);
     newNode.next = top;  // New node points to the current top
     top = newNode;  // Update the top to the new node
     System.out.println(title + " pushed onto the stack.");
 }

 // Method to pop the top scroll off the stack
 public String pop() {
     if (top == null) {
         System.out.println("The stack is empty. No scroll to pop.");
         return null;
     }
     String poppedTitle = top.title;  // Save the title of the top scroll
     top = top.next;  // Move the top to the next node
     System.out.println(poppedTitle + " popped from the stack.");
     return poppedTitle;
 }

 // Method to peek at the top scroll without removing it
 public String peek() {
     if (top == null) {
         System.out.println("The stack is empty. No scroll to peek at.");
         return null;
     }
     System.out.println("Top scroll is: " + top.title);
     return top.title;
 }

 // Method to check if a specific scroll title exists in the stack
 public boolean contains(String title) {
     ScrollNode current = top;
     while (current != null) {
         if (current.title.equals(title)) {
             return true;  // Scroll found
         }
         current = current.next;  // Move to the next node
     }
     return false;  // Scroll not found
 }

 // Main method for testing
 public static void main(String[] args) {
     ScrollStack stack = new ScrollStack();

     // Push scrolls onto the stack
     stack.push("Scroll of Fire");
     stack.push("Scroll of Water");
     stack.push("Scroll of Earth");

     // Peek at the top scroll
     stack.peek();

     // Check if a specific scroll exists
     System.out.println("Contains 'Scroll of Water'? " + stack.contains("Scroll of Water"));

     // Pop the top scroll
     stack.pop();

     // Peek again to see the new top
     stack.peek();
 }
}
