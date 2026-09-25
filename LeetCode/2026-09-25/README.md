# LeetCode Practice - 2026-09-25 (Day 05: Linked List)

Today's practice session focuses on fundamental and advanced **Linked List** algorithms, pattern recognition, and pointer manipulations in Java.

---

## Problems Solved (9 Problems)

| # | Problem Name | LeetCode # | Difficulty | Core Pattern / Strategy | Solution Link |
|---|--------------|------------|------------|-------------------------|---------------|
| 36 | Middle of the Linked List | [876](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Fast & Slow Pointers | [MiddleOfLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/MiddleOfLinkedList.java) |
| 37 | Linked List Cycle | [141](https://leetcode.com/problems/linked-list-cycle/) | Easy | Floyd's Cycle Detection (Tortoise & Hare) | [LinkedListCycle.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/LinkedListCycle.java) |
| 38 | Linked List Cycle II | [142](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | Cycle Detection + Entry Math ($L_1 = nC - L_2$) | [LinkedListCycleII.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/LinkedListCycleII.java) |
| 39 | Merge Two Sorted Lists | [21](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Dummy Node & Iterative Pointer Splicing | [MergeTwoSortedLists.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/MergeTwoSortedLists.java) |
| 40 | Remove Nth Node From End of List | [19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Two Pointers with $N$-gap + Dummy Node | [RemoveNthNodeFromEnd.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/RemoveNthNodeFromEnd.java) |
| 41 | Reorder List | [143](https://leetcode.com/problems/reorder-list/) | Medium | Find Mid -> Reverse 2nd Half -> Interleave | [ReorderList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/ReorderList.java) |
| 42 | Copy List with Random Pointer | [138](https://leetcode.com/problems/copy-list-with-random-pointer/) | Medium | 3-Pass Interleaving ($O(1)$ Extra Space) | [CopyListWithRandomPointer.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/CopyListWithRandomPointer.java) |
| 43 | Add Two Numbers | [2] (https://leetcode.com/problems/add-two-numbers/) | Medium | Dummy Node & Digit-by-Digit Carry Addition | [AddTwoNumbers.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/AddTwoNumbers.java) |
| 44 | Merge k Sorted Lists | [23](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | PriorityQueue Min-Heap ($O(N \log K)$) | [MergeKSortedLists.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-25/MergeKSortedLists.java) |

---

## Key Algorithmic Takeaways

1. **Fast & Slow Pointers (Floyd's Algorithm)**:
   - Used for finding the middle node in $O(N)$ time with $O(1)$ space (`MiddleOfLinkedList`).
   - Used for cycle detection (`LinkedListCycle`) and finding the exact cycle entry node (`LinkedListCycleII`).

2. **Dummy Node Technique**:
   - Eliminates special boundary checks for edge cases (e.g. deleting the head node in `RemoveNthNodeFromEnd` or appending to empty lists in `MergeTwoSortedLists` and `AddTwoNumbers`).

3. **3-Pass Interleaving Strategy**:
   - Deep copying nodes with random pointers in $O(1)$ space without requiring a Hash Map lookup by cloning inline ($A \to A' \to B \to B'$).

4. **Heap-Based $K$-Way Merge**:
   - Using `PriorityQueue` min-heap to achieve $O(N \log K)$ merge time across $K$ sorted lists efficiently.

---

## Verification & Test Results

All 9 solutions include standalone `main` method execution harnesses and runtime assertions. Verified clean compilation and execution:
```bash
javac Day05_Linked_List/*.java
java Day05_Linked_List.MiddleOfLinkedList
java Day05_Linked_List.LinkedListCycle
java Day05_Linked_List.LinkedListCycleII
java Day05_Linked_List.MergeTwoSortedLists
java Day05_Linked_List.RemoveNthNodeFromEnd
java Day05_Linked_List.ReorderList
java Day05_Linked_List.CopyListWithRandomPointer
java Day05_Linked_List.AddTwoNumbers
java Day05_Linked_List.MergeKSortedLists
```
Status: **ALL 81 COMMITS GENERATED & VERIFIED PASSED**
