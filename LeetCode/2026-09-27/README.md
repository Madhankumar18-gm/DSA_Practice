# LeetCode Solutions - September 27, 2026 (Day 07: Doubly Linked List)

This directory contains standalone Java implementations for 9 LeetCode-style problems and data structure designs centered on **Doubly Linked Lists (DLL)**. Each problem includes complete source code with static inner Node definitions, O(1) sentinel node mechanics, auxiliary frequency buckets, two-pointer techniques, and comprehensive main method test harnesses with runtime assertions.

---

## 📅 Daily Problem Matrix

| # | Problem Name | Difficulty | Key Pattern / Techniques | Java File |
|---|---|---|---|---|
| 1 | [LeetCode 146] LRU Cache | Medium | Doubly Linked List + HashMap, O(1) Get/Put, Sentinel Nodes | [`LRUCache.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/LRUCache.java) |
| 2 | [LeetCode 460] LFU Cache | Hard | Frequency Buckets (DLL per Freq) + HashMap, O(1) Operations | [`LFUCache.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/LFUCache.java) |
| 3 | [LeetCode 430] Flatten Multilevel DLL | Medium | Recursive/Iterative Child Splicing, DLL Pointer Wiring | [`FlattenMultilevelDoublyLinkedList.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/FlattenMultilevelDoublyLinkedList.java) |
| 4 | [LeetCode 206 Var] Reverse Doubly Linked List | Easy | In-Place `prev`/`next` Pointer Swapping | [`ReverseDoublyLinkedList.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/ReverseDoublyLinkedList.java) |
| 5 | [LeetCode 1472] Design Browser History | Medium | DLL Current Page Pointer, Dynamic History Truncation | [`DesignBrowserHistory.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/DesignBrowserHistory.java) |
| 6 | [LeetCode 641] Design Circular Deque using DLL | Medium | Sentinel Head/Tail, Double-Ended Queue Operations | [`DesignDequeUsingDoublyLinkedList.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/DesignDequeUsingDoublyLinkedList.java) |
| 7 | [GFG/LeetCode] Remove Given Node in Doubly Linked List | Easy | Node Unlinking, Neighbor Pointer Re-wiring | [`RemoveNodeInDoublyLinkedList.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/RemoveNodeInDoublyLinkedList.java) |
| 8 | [GFG/LeetCode] Merge Sort for Doubly Linked List | Medium | Split-by-Fast/Slow, Iterative DLL Merge, $O(N \log N)$ | [`SortDoublyLinkedList.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/SortDoublyLinkedList.java) |
| 9 | [GFG/LeetCode] Pair Sum in Sorted Doubly Linked List | Easy | Bi-directional Two Pointers (`head` & `tail`) | [`PairSumInSortedDoublyLinkedList.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-27/PairSumInSortedDoublyLinkedList.java) |

---

## 🔑 Key Patterns & Learnings

1. **Sentinel Nodes (`head` and `tail`)**: Eliminates edge cases (null checks for empty lists, single node removal, front/back insertion) by keeping dummy boundary nodes.
2. **Frequency Bucketing (LFU Cache)**: Managing dynamic double linkage across multiple frequency tiers allows $O(1)$ removal and eviction of the least frequently used items.
3. **Bi-directional Traversal**: Leveraged in two-pointer pair sum search and browser navigation (`back`/`forward`) to achieve linear time operations without auxiliary space.
4. **Merge Sort on DLL**: $O(N \log N)$ sorting maintaining bidirectional invariants (`prev` and `next` pointers) across split and merge phases.
