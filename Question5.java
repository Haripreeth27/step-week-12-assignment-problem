/**
 * Category C · Coding Assignment
 * Problem 5: Plate Stack on a Chain
 * 
 * TASK:
 * In the mess, clean plates are stacked and the top plate is always taken first. Build this stack using
 * a chain of nodes instead of an array, so it never becomes full.
 * 
 * Implement:
 *   push(String plate)
 *   pop()
 *   peek()
 *   isEmpty()
 * 
 * where the top of the stack is the head of the chain. Write your own node class with data and next fields;
 * do not use java.util.LinkedList.
 * 
 * COMPLEXITY REQUIREMENTS & COMPARISON WITH ARRAY-BASED STACK:
 * - Time Complexity:
 *   - push(x): O(1) time - inserts node at the head.
 *   - pop(): O(1) time - removes node from the head.
 *   - peek(): O(1) time - inspects head node data.
 *   - isEmpty(): O(1) time - checks if head is null.
 * - Space Complexity: O(n) auxiliary memory for n stored elements.
 * - Comparison with Array-Based Stack:
 *   - An array-based stack provides amortized O(1) push, but suffers from O(n) worst-case resizing costs
 *     when capacity is reached, or risks StackOverflow if size is bounded.
 *   - A chain-based stack never overflows (bounded only by JVM heap memory), requires no resizing/copying,
 *     and guarantees strictly O(1) worst-case time for every single operation.
 */
public class Question5 {

    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class PlateStack {
        private Node top;
        private int size;

        public PlateStack() {
            this.top = null;
            this.size = 0;
        }

        /**
         * Pushes a new plate onto the stack.
         */
        public void push(String plate) {
            Node newNode = new Node(plate);
            newNode.next = top;
            top = newNode;
            size++;
            System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
        }

        /**
         * Removes and returns the top plate from the stack.
         */
        public String pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return null;
            }
            String popped = top.data;
            top = top.next;
            size--;
            System.out.println("pop -> " + popped + ", size " + size);
            return popped;
        }

        /**
         * Inspects the top plate without removing it.
         */
        public String peek() {
            if (isEmpty()) {
                System.out.println("peek -> stack is empty");
                return null;
            }
            System.out.println("peek -> " + top.data);
            return top.data;
        }

        /**
         * Returns true if stack is empty, false otherwise.
         */
        public boolean isEmpty() {
            return top == null;
        }

        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        // push(P1), push(P2), peek(), pop(), push(P3), pop(), pop(), pop(), isEmpty()
        PlateStack stack = new PlateStack();
        stack.push("P1");
        stack.push("P2");
        stack.peek();
        stack.pop();
        stack.push("P3");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty -> " + stack.isEmpty());

        System.out.println("\n--- Custom Test Case ---");
        PlateStack customStack = new PlateStack();
        System.out.println("isEmpty initially -> " + customStack.isEmpty());
        customStack.pop();
        customStack.peek();
        customStack.push("PlateA");
        customStack.push("PlateB");
        customStack.peek();
        customStack.pop();
        customStack.pop();
        System.out.println("isEmpty after clearing -> " + customStack.isEmpty());
    }
}
