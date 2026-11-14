/**
 * Category C · Coding Assignment
 * Problem 1: Bus Route Stops
 * 
 * TASK:
 * A college bus route is stored as a chain of stops. Build the chain from the stop names in order, print it,
 * and print the number of stops with the first and last stop.
 * 
 * Implement:
 *   Node build(String[] stops)
 *   void printRoute(Node head)
 * 
 * Write your own node class with data and next fields; do not use java.util.LinkedList.
 * 
 * COMPLEXITY:
 * - Building chain: O(n) time, where n is the number of stops.
 * - Printing route: O(n) time to traverse from head to null.
 * - Space complexity: O(n) memory to store n Node instances.
 */
public class Question1 {

    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Builds a linked list chain from an array of stop names in order.
     *
     * @param stops array of stop names
     * @return head of the built linked chain
     */
    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) {
            return null;
        }

        Node head = new Node(stops[0]);
        Node tail = head;

        for (int i = 1; i < stops.length; i++) {
            tail.next = new Node(stops[i]);
            tail = tail.next;
        }

        return head;
    }

    /**
     * Prints the chain in the format a -> b -> ... -> null,
     * followed by total stops, first stop, and last stop.
     *
     * @param head head of the chain
     */
    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Node curr = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            count++;
            last = curr.data;
            curr = curr.next;
        }
        sb.append("null");

        System.out.println(sb.toString());
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        System.out.println("--- Sample 1 ---");
        String[] stops1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node route1 = build(stops1);
        printRoute(route1);

        System.out.println("\n--- Sample 2 ---");
        String[] stops2 = {"Potheri"};
        Node route2 = build(stops2);
        printRoute(route2);

        System.out.println("\n--- Custom Test Case ---");
        String[] stopsCustom = {"Airport", "Meenambakkam", "Alandur", "Saidapet"};
        Node routeCustom = build(stopsCustom);
        printRoute(routeCustom);
    }
}
