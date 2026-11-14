/**
 * Category C · Coding Assignment
 * Problem 2: Late Comers in the Line
 * 
 * TASK:
 * Students stand in a line stored as a chain of names. A student with a pass joins at the front;
 * any other late comer joins at the end.
 * 
 * Implement:
 *   Node addFirst(Node head, String name)
 *   Node addLast(Node head, String name)
 * 
 * Apply the operations in order and print the final line. Write your own node class with data
 * and next fields; do not use java.util.LinkedList.
 * 
 * COMPLEXITY:
 * - addFirst: O(1) time complexity (creates a new node pointing to old head and becomes new head).
 * - addLast: O(n) time complexity (traverses n nodes from head to reach the last node and append).
 * - Space complexity: O(1) auxiliary space per addition.
 */
public class Question2 {

    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds a student to the front of the line (with pass).
     *
     * @param head current head of the line
     * @param name student name
     * @return new head of the line
     */
    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    /**
     * Adds a late comer student to the end of the line.
     *
     * @param head current head of the line
     * @param name student name
     * @return head of the line
     */
    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) {
            return newNode;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    /**
     * Prints the line in format a -> b -> ... -> null.
     */
    public static void printLine(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("--- Sample 1 ---");
        // line = Asha -> Ravi
        Node line1 = new Node("Asha");
        line1.next = new Node("Ravi");

        // addFirst(Neha), addLast(Kiran), addFirst(Mohan)
        line1 = addFirst(line1, "Neha");
        line1 = addLast(line1, "Kiran");
        line1 = addFirst(line1, "Mohan");
        printLine(line1); // Expected: Mohan -> Neha -> Asha -> Ravi -> Kiran -> null

        System.out.println("\n--- Sample 2 ---");
        // line = (empty)
        Node line2 = null;

        // addLast(Pooja), addFirst(Arun)
        line2 = addLast(line2, "Pooja");
        line2 = addFirst(line2, "Arun");
        printLine(line2); // Expected: Arun -> Pooja -> null

        System.out.println("\n--- Custom Test Case ---");
        Node lineCustom = null;
        lineCustom = addFirst(lineCustom, "Dev");
        lineCustom = addLast(lineCustom, "Kavya");
        lineCustom = addLast(lineCustom, "Sanjay");
        lineCustom = addFirst(lineCustom, "Anu");
        printLine(lineCustom); // Expected: Anu -> Dev -> Kavya -> Sanjay -> null
    }
}
