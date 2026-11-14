/**
 * Category C · Coding Assignment
 * Problem 4: Cancel a Booking
 * 
 * TASK:
 * Room bookings are kept as a chain of booking numbers. When a booking is cancelled, remove its
 * first appearance from the chain. If the booking is not in the chain, print a message and leave
 * the chain unchanged.
 * 
 * Implement:
 *   Node removeFirst(Node head, String booking)
 * 
 * and return the (possibly new) head. Write your own node class with data and next fields;
 * do not use java.util.LinkedList.
 * 
 * COMPLEXITY:
 * - When booking is at the head: O(1) time complexity (simply advance head to head.next).
 * - When booking is at the end or not found: O(n) time complexity (must traverse all n nodes
 *   to locate predecessor or confirm absence).
 * - Space complexity: O(1) auxiliary space (in-place pointer updates).
 */
public class Question4 {

    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Removes the first occurrence of booking from the chain.
     *
     * @param head head of the chain
     * @param booking booking ID to cancel
     * @return updated head of the chain
     */
    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        // Handle head removal
        if (booking.equals(head.data)) {
            return head.next;
        }

        // Search for node to remove, stopping at predecessor
        Node curr = head;
        while (curr.next != null && !booking.equals(curr.next.data)) {
            curr = curr.next;
        }

        if (curr.next != null) {
            // Found: bypass curr.next
            curr.next = curr.next.next;
        } else {
            // Not found
            System.out.println(booking + " not found");
        }

        return head;
    }

    /**
     * Helper to print chain.
     */
    public static void printChain(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
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
        System.out.println("--- Sample 1 ---");
        // bookings = 104 -> 101 -> 107 -> 101, cancel = 101
        Node bookings1 = buildChain(new String[]{"104", "101", "107", "101"});
        bookings1 = removeFirst(bookings1, "101");
        printChain(bookings1); // Expected: 104 -> 107 -> 101 -> null

        System.out.println("\n--- Sample 2 ---");
        // bookings = 104 -> 101 -> 107, cancel = 104
        Node bookings2 = buildChain(new String[]{"104", "101", "107"});
        bookings2 = removeFirst(bookings2, "104");
        printChain(bookings2); // Expected: 101 -> 107 -> null

        System.out.println("\n--- Sample 3 ---");
        // bookings = 104 -> 101, cancel = 200
        Node bookings3 = buildChain(new String[]{"104", "101"});
        bookings3 = removeFirst(bookings3, "200");
        printChain(bookings3); // Expected: 200 not found \n 104 -> 101 -> null

        System.out.println("\n--- Custom Test Case (Cancel last element) ---");
        Node bookingsCustom = buildChain(new String[]{"301", "302", "303"});
        bookingsCustom = removeFirst(bookingsCustom, "303");
        printChain(bookingsCustom); // Expected: 301 -> 302 -> null
    }
}
