# 📅 Daily LeetCode & Data Structures Study Log - September 29, 2026

## 🎯 Day 09 Focus: Circular Linked List (CLL) Algorithms & Implementations

Today's practice covers **12 comprehensive Circular Linked List problems** in Java, spanning ring insertion, elimination games, split algorithms, cycle detection/disconnection, reversals, queue design, counting, rotation, sorted merging, and circular doubly linked lists.

---

## 💡 Topic Overview: Circular Linked List Mechanics

A **Circular Linked List (CLL)** is a variation of a linked list where all nodes form a continuous loop:
- In a **Singly Circular Linked List**, the `next` pointer of the last node points back to the `head` (or `tail.next == head`).
- In a **Doubly Circular Linked List (CDLL)**, `head.prev` points to `tail` and `tail.next` points to `head`.

### Key Advantages & Patterns:
1. **Single Tail Pointer Pattern**: Maintaining a single `tail` reference allows $O(1)$ access to both `head` (`tail.next`) and `tail`, enabling $O(1)$ Queue operations (`enqueue` at tail, `dequeue` at head).
2. **Ring Traversal**: Iterating through a circular list requires `do-while` loops (e.g., `do { ... curr = curr.next; } while (curr != head);`) to avoid missing the head node.
3. **Split & Interleave**: Splitting or merging circular lists requires updating tail pointer boundaries to maintain the closed ring invariant.

---

## 📝 Problem Summary Table (Day 09 - 12 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P72) | **[LeetCode 708] Insert into a Sorted Circular Linked List** | Medium | Ring Traversal & Min/Max Boundary Insertion | [InsertIntoSortedCircularLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/InsertIntoSortedCircularLinkedList.java) |
| 2 (P73) | **[LeetCode 1823] Find Winner of Circular Game (Josephus)** | Medium | Circular Ring Node Elimination Simulation | [FindWinnerOfCircularGame.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/FindWinnerOfCircularGame.java) |
| 3 (P74) | **Split Circular Linked List Into Two Halves** | Medium | Fast & Slow Pointer Mid-split & Ring Re-wiring | [SplitCircularLinkedListIntoTwoHalves.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/SplitCircularLinkedListIntoTwoHalves.java) |
| 4 (P75) | **Check if a Linked List is Circular** | Easy | Head Loop Traversal & Origin Reachability | [CheckIfLinkedListIsCircular.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/CheckIfLinkedListIsCircular.java) |
| 5 (P76) | **Deletion in a Circular Linked List** | Medium | Head/Tail/Middle Pointer Unlinking & Tail Update | [DeletionInCircularLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/DeletionInCircularLinkedList.java) |
| 6 (P77) | **Detect and Disconnect Circular List** | Medium | Floyd's Tortoise & Hare Cycle Break | [DetectAndDisconnectCircularList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/DetectAndDisconnectCircularList.java) |
| 7 (P78) | **Reverse a Circular Linked List** | Medium | In-place 3-Pointer Reversal & Tail Pointer Wiring | [ReverseCircularLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/ReverseCircularLinkedList.java) |
| 8 (P79) | **Design Circular Singly Linked List Queue** | Medium | Single Tail Pointer $O(1)$ Enqueue & Dequeue | [DesignCircularLinkedListQueue.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/DesignCircularLinkedListQueue.java) |
| 9 (P80) | **Count Nodes in a Circular Linked List** | Easy | Do-While Ring Pointer Traversal | [CountNodesInCircularLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/CountNodesInCircularLinkedList.java) |
| 10 (P81) | **Rotate a Circular Linked List** | Medium | Head Pointer Advancement & Ring Splitting | [RotateCircularLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/RotateCircularLinkedList.java) |
| 11 (P82) | **Merge Two Sorted Circular Linked Lists** | Medium | Dual Pointer Ring Interleaving | [MergeSortedCircularLinkedLists.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/MergeSortedCircularLinkedLists.java) |
| 12 (P83) | **Sorted Insert in Circular Doubly Linked List** | Medium | Bidirectional Ring `prev`/`next` Re-wiring | [SortedInsertCircularDoublyLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-29/SortedInsertCircularDoublyLinkedList.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day09_Circular_Linked_List/*.java
java -ea Day09_Circular_Linked_List.InsertIntoSortedCircularLinkedList
java -ea Day09_Circular_Linked_List.FindWinnerOfCircularGame
java -ea Day09_Circular_Linked_List.SplitCircularLinkedListIntoTwoHalves
java -ea Day09_Circular_Linked_List.CheckIfLinkedListIsCircular
java -ea Day09_Circular_Linked_List.DeletionInCircularLinkedList
java -ea Day09_Circular_Linked_List.DetectAndDisconnectCircularList
java -ea Day09_Circular_Linked_List.ReverseCircularLinkedList
java -ea Day09_Circular_Linked_List.DesignCircularLinkedListQueue
java -ea Day09_Circular_Linked_List.CountNodesInCircularLinkedList
java -ea Day09_Circular_Linked_List.RotateCircularLinkedList
java -ea Day09_Circular_Linked_List.MergeSortedCircularLinkedLists
java -ea Day09_Circular_Linked_List.SortedInsertCircularDoublyLinkedList
```

All 12 files passed all assertion checks cleanly!
