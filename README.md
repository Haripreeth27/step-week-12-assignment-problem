# STEP Week 12 — Category C · Linked Lists & Stacks

This repository contains the complete Java solutions for the **STEP Sem-3 Week 12 Coding Assignment Problems (Category C · Linked Lists & Dynamic Data Structures)** provided by CodInClub | Powered by BridgeLabz.

All node-based structures and algorithms are implemented from scratch using custom `Node` classes without using `java.util.LinkedList`. Each program contains full solutions, sample inputs, and custom test cases.

---

## Problems & Solutions

| Question | Problem Name | Data Structure / Operation | Key Methods | File |
| :--- | :--- | :--- | :--- | :--- |
| **Question 1** | Bus Route Stops | Singly Linked List Traversal | `build(String[] stops)`, `printRoute(Node head)` | [`Question1.java`](Question1.java) |
| **Question 2** | Late Comers in the Line | Insert at Head / Insert at Tail | `addFirst(Node head, String name)`, `addLast(Node head, String name)` | [`Question2.java`](Question2.java) |
| **Question 3** | Book Copy Finder | Linear Search with Counters | `find(Node head, String id)` | [`Question3.java`](Question3.java) |
| **Question 4** | Cancel a Booking | Singly Linked List Node Deletion | `removeFirst(Node head, String booking)` | [`Question4.java`](Question4.java) |
| **Question 5** | Plate Stack on a Chain | Linked Stack Implementation | `push(String plate)`, `pop()`, `peek()`, `isEmpty()` | [`Question5.java`](Question5.java) |

---

## Problem Summaries & Complexity Analysis

### Question 1: Bus Route Stops
- **Task:** Build a chain of stops from an array of stop names in order, print the chain in format `a -> b -> ... -> null`, and display total stops, first stop, and last stop.
- **Complexity:**
  - Building the chain: $O(n)$ time using a tail pointer to append each node in $O(1)$.
  - Printing route: $O(n)$ time traversing from head to null.
  - Space complexity: $O(n)$ memory to store $n$ nodes.

### Question 2: Late Comers in the Line
- **Task:** Students stand in a chain. A student with a pass joins at the front (`addFirst`), while any other late comer joins at the end (`addLast`).
- **Complexity:**
  - `addFirst`: $O(1)$ time complexity (new node's next is old head).
  - `addLast`: $O(n)$ time complexity (traverses the chain to reach the last node).

### Question 3: Book Copy Finder
- **Task:** Find the 1-based position of the first occurrence of a book ID and the total copy count on a returns trolley in a single walk.
- **Complexity:** $O(n)$ time complexity, $O(1)$ auxiliary space.
- **Random Access Discussion:** In an array, elements are in contiguous memory allowing $O(1)$ random access by calculating `address = base + index * size`. In a linked list, nodes are dispersed in heap memory and linked by pointers; jumping to the middle is impossible without following pointer references sequentially in $O(n)$ steps.

### Question 4: Cancel a Booking
- **Task:** Remove the first occurrence of a booking number from the chain. If not found, print a message and leave the chain unchanged.
- **Complexity:**
  - When booking is at the head: $O(1)$ time complexity (`head = head.next`).
  - When booking is at the end or not found: $O(n)$ time complexity (requires full traversal).

### Question 5: Plate Stack on a Chain
- **Task:** Implement a dynamic stack using a chain of nodes where top is the head, ensuring the stack never overflows.
- **Complexity:**
  - `push`, `pop`, `peek`, `isEmpty`: All strictly $O(1)$ worst-case time complexity.
- **Comparison with Array-Based Stack:**
  - Array-based stack offers amortized $O(1)$ push, but incurs $O(n)$ copy/resizing penalties when full, or causes stack overflow if capacity is bounded.
  - Linked-list stack never becomes full (limited only by JVM heap memory), requires no resizing overhead, and guarantees $O(1)$ worst-case time for every push/pop.

---

## How to Compile and Run

```bash
cd step-week-12-assignment-problem

# Question 1: Bus Route Stops
javac Question1.java && java Question1

# Question 2: Late Comers in the Line
javac Question2.java && java Question2

# Question 3: Book Copy Finder
javac Question3.java && java Question3

# Question 4: Cancel a Booking
javac Question4.java && java Question4

# Question 5: Plate Stack on a Chain
javac Question5.java && java Question5
```
