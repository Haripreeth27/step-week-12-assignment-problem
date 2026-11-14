/**
 * Category C · Coding Assignment
 * Problem 3: Book Copy Finder
 * 
 * TASK:
 * Book IDs on a returns trolley are stored as a chain. Find the position of the first copy of a given book
 * (counting from 1) and how many copies are on the trolley.
 * 
 * Implement:
 *   String find(Node head, String id)
 * 
 * with one walk through the chain. Compare IDs with equals. Write your own node class with data
 * and next fields; do not use java.util.LinkedList.
 * 
 * COMPLEXITY & RANDOM ACCESS:
 * - Time Complexity: O(n) where n is the length of the chain, visiting each node exactly once.
 * - Space Complexity: O(1) auxiliary memory.
 * - Why you cannot jump straight to the middle of a chain:
 *   Unlike arrays where elements reside in contiguous memory locations enabling instant O(1)
 *   direct access via address arithmetic (address = base + index * size), a linked list stores
 *   nodes at arbitrary locations in heap memory. Each node only stores a pointer reference to
 *   its immediate successor. Hence, reaching any node requires sequentially traversing pointers
 *   from the head node in O(n) steps.
 */
public class Question3 {

    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Finds the first position (1-based) and count of copies for a given book ID in one traversal.
     *
     * @param head head of the book chain
     * @param id book ID to find
     * @return summary string of position and count, or not found message
     */
    public static String find(Node head, String id) {
        if (head == null || id == null) {
            return id + " not found";
        }

        int pos = 1;
        int firstPos = -1;
        int copies = 0;
        Node curr = head;

        while (curr != null) {
            if (id.equals(curr.data)) {
                if (firstPos == -1) {
                    firstPos = pos;
                }
                copies++;
            }
            pos++;
            curr = curr.next;
        }

        if (copies > 0) {
            return id + " first at position " + firstPos + ", copies: " + copies;
        } else {
            return id + " not found";
        }
    }

    /**
     * Helper to build a chain from an array.
     */
    public static Node buildChain(String[] items) {
        if (items == null || items.length == 0) return null;
        Node head = new Node(items[0]);
        Node tail = head;
        for (int i = 1; i < items.length; i++) {
            tail.next = new Node(items[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // trolley = B12 -> B07 -> B30 -> B07 -> B45 -> B07
        String[] trolleyItems = {"B12", "B07", "B30", "B07", "B45", "B07"};
        Node trolley = buildChain(trolleyItems);

        System.out.println("--- Sample 1 ---");
        System.out.println(find(trolley, "B07")); // Expected: B07 first at position 2, copies: 3

        System.out.println("\n--- Sample 2 ---");
        System.out.println(find(trolley, "B99")); // Expected: B99 not found

        System.out.println("\n--- Custom Test Case ---");
        System.out.println(find(trolley, "B12")); // Expected: B12 first at position 1, copies: 1
    }
}
