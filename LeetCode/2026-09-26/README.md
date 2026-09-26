# LeetCode Practice - 2026-09-26 (Day 06: Singly Linked List)

Today's study session focuses on advanced **Singly Linked List** pointer manipulations, in-place reversals, group operations, and dual-pointer techniques in Java.

---

## Problems Solved (9 Problems)

| # | Problem Name | LeetCode # | Difficulty | Core Pattern / Strategy | Solution Link |
|---|--------------|------------|------------|-------------------------|---------------|
| 45 | Palindrome Linked List | [234](https://leetcode.com/problems/palindrome-linked-list/) | Easy | Fast/Slow Mid Finding + Half Reversal | [PalindromeLinkedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/PalindromeLinkedList.java) |
| 46 | Intersection of Two Linked Lists | [160](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | Dual Pointer Traversal ($O(N+M)$) | [IntersectionOfTwoLinkedLists.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/IntersectionOfTwoLinkedLists.java) |
| 47 | Remove Duplicates from Sorted List | [83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | Easy | Single-Pass Pointer Splicing | [RemoveDuplicatesFromSortedList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/RemoveDuplicatesFromSortedList.java) |
| 48 | Remove Duplicates from Sorted List II | [82](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | Medium | Dummy Node & Predecessor Pointer | [RemoveDuplicatesFromSortedListII.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/RemoveDuplicatesFromSortedListII.java) |
| 49 | Partition List | [86](https://leetcode.com/problems/partition-list/) | Medium | Dual Dummy Buckets (Less & Greater) | [PartitionList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/PartitionList.java) |
| 50 | Rotate List | [61](https://leetcode.com/problems/rotate-list/) | Medium | Circular Ring Connection & Tail Break | [RotateList.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/RotateList.java) |
| 51 | Reverse Linked List II | [92](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium | One-Pass In-place Subsegment Reversal | [ReverseLinkedListII.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/ReverseLinkedListII.java) |
| 52 | Swap Nodes in Pairs | [24](https://leetcode.com/problems/swap-nodes-in-pairs/) | Medium | Iterative Pair Splicing with Dummy Node | [SwapNodesInPairs.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/SwapNodesInPairs.java) |
| 53 | Reverse Nodes in k-Group | [25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | $K$-Group Segment Reversal ($O(1)$ Space) | [ReverseNodesInKGroup.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-26/ReverseNodesInKGroup.java) |

---

## Key Algorithmic Takeaways

1. **In-Place Subsegment Reversal**:
   - `ReverseLinkedListII` and `ReverseNodesInKGroup` use dummy nodes and predecessor pointers to reverse subsegments of singly linked lists in $O(1)$ auxiliary space.

2. **Dual-Bucket Partitioning**:
   - `PartitionList` uses two independent dummy heads (`beforeHead` and `afterHead`) to partition elements around pivot $x$ while preserving original relative ordering.

3. **Ring Formation & Rotation**:
   - `RotateList` forms a circular ring by connecting `oldTail.next = head`, computes effective rotation $k \% N$, and severs the link at position $(N - k - 1)$.

4. **Dual Pointer Redirection**:
   - `IntersectionOfTwoLinkedLists` redirects pointer $A$ to `headB` and pointer $B$ to `headA` upon hitting `null`, ensuring both pointers traverse equal distance $(lenA + lenB)$ to meet at the intersection point.

---

## Verification & Test Results

All 9 Java source files feature standalone `main` execution suites with runtime assertions. Verified clean compilation and execution:
```bash
javac Day06_Singly_Linked_List/*.java
java Day06_Singly_Linked_List.PalindromeLinkedList
java Day06_Singly_Linked_List.IntersectionOfTwoLinkedLists
java Day06_Singly_Linked_List.RemoveDuplicatesFromSortedList
java Day06_Singly_Linked_List.RemoveDuplicatesFromSortedListII
java Day06_Singly_Linked_List.PartitionList
java Day06_Singly_Linked_List.RotateList
java Day06_Singly_Linked_List.ReverseLinkedListII
java Day06_Singly_Linked_List.SwapNodesInPairs
java Day06_Singly_Linked_List.ReverseNodesInKGroup
```
Status: **ALL 81 COMMITS GENERATED & VERIFIED PASSED**
