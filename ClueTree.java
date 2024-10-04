package ClueTree;

//Node class to represent each clue in the binary tree
class ClueNode {
 String clue;          // The clue at this node
 ClueNode left;        // Pointer to the left child node
 ClueNode right;       // Pointer to the right child node

 // Constructor to create a new ClueNode
 public ClueNode(String clue) {
     this.clue = clue;
     this.left = null;
     this.right = null;
 }
}

//ClueTree class to manage the binary tree of clues
public class ClueTree {
 private ClueNode root;  // The root node of the tree

 // Constructor to initialize an empty tree
 public ClueTree() {
     this.root = null;
 }

 // Method to insert a new clue into the tree
 public void insert(String clue) {
     root = insertRecursive(root, clue);
 }

 // Helper method to recursively insert a new clue
 private ClueNode insertRecursive(ClueNode node, String clue) {
     if (node == null) {
         return new ClueNode(clue);  // Insert new node if tree is empty
     }

     // For simplicity, we assume clues are inserted alphabetically
     if (clue.compareTo(node.clue) < 0) {
         node.left = insertRecursive(node.left, clue);  // Insert into left subtree
     } else if (clue.compareTo(node.clue) > 0) {
         node.right = insertRecursive(node.right, clue);  // Insert into right subtree
     }
     return node;
 }

 // Method to perform in-order traversal of the tree
 public void inOrderTraversal() {
     inOrderRecursive(root);
     System.out.println();  // New line after traversal
 }

 // Helper method for in-order traversal (left, root, right)
 private void inOrderRecursive(ClueNode node) {
     if (node != null) {
         inOrderRecursive(node.left);
         System.out.print(node.clue + " ");
         inOrderRecursive(node.right);
     }
 }

 // Method to perform pre-order traversal of the tree
 public void preOrderTraversal() {
     preOrderRecursive(root);
     System.out.println();  // New line after traversal
 }

 // Helper method for pre-order traversal (root, left, right)
 private void preOrderRecursive(ClueNode node) {
     if (node != null) {
         System.out.print(node.clue + " ");
         preOrderRecursive(node.left);
         preOrderRecursive(node.right);
     }
 }

 // Method to perform post-order traversal of the tree
 public void postOrderTraversal() {
     postOrderRecursive(root);
     System.out.println();  // New line after traversal
 }

 // Helper method for post-order traversal (left, right, root)
 private void postOrderRecursive(ClueNode node) {
     if (node != null) {
         postOrderRecursive(node.left);
         postOrderRecursive(node.right);
         System.out.print(node.clue + " ");
     }
 }

 // Method to search for a specific clue in the tree
 public boolean search(String clue) {
     return searchRecursive(root, clue);
 }

 // Helper method to recursively search for a clue
 private boolean searchRecursive(ClueNode node, String clue) {
     if (node == null) {
         return false;  // Clue not found
     }

     if (node.clue.equals(clue)) {
         return true;  // Clue found
     }

     // Search left or right subtree based on the clue's value
     if (clue.compareTo(node.clue) < 0) {
         return searchRecursive(node.left, clue);
     } else {
         return searchRecursive(node.right, clue);
     }
 }

 // Method to count the total number of clues in the tree
 public int countClues() {
     return countCluesRecursive(root);
 }

 // Helper method to recursively count the nodes in the tree
 private int countCluesRecursive(ClueNode node) {
     if (node == null) {
         return 0;  // No node here
     }
     // Count this node plus the nodes in left and right subtrees
     return 1 + countCluesRecursive(node.left) + countCluesRecursive(node.right);
 }

 // Main method for testing
 public static void main(String[] args) {
     ClueTree tree = new ClueTree();

     // Insert clues into the tree
     tree.insert("Clue A");
     tree.insert("Clue B");
     tree.insert("Clue C");
     tree.insert("Clue D");

     // Perform various traversals
     System.out.println("In-Order Traversal:");
     tree.inOrderTraversal();

     System.out.println("Pre-Order Traversal:");
     tree.preOrderTraversal();

     System.out.println("Post-Order Traversal:");
     tree.postOrderTraversal();

     // Search for a specific clue
     System.out.println("Is 'Clue C' in the tree? " + tree.search("Clue C"));

     // Count the number of clues in the tree
     System.out.println("Total number of clues: " + tree.countClues());
 }
}
