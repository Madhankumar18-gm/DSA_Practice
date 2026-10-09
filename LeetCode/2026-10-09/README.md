# 📅 Daily LeetCode & Data Structures Study Log - October 09, 2026

## 🎯 Day 17 Focus: Heaps & Priority Queue (Min-Heap, Max-Heap, Heap Sort)

Today's practice covers **7 comprehensive Heap & Priority Queue problems** in Java, spanning Kth largest element selection, frequency clustering, dynamic median stream maintenance, multi-way list merging, geometric proximity filtering, CPU task scheduling with cooldowns, and in-place Heap Sort.

---

## 💡 Topic Overview: Heaps & Priority Queue Mechanics

Mastering **Heaps & Priority Queues** enables optimal time complexity when tracking extreme (min/max) values in dynamic sets:
1. **Top-K Pattern (Min-Heap of size K)**: To find the K largest elements, maintain a Min-Heap of size K. Discard smaller elements. The root always stores the Kth largest element in $O(N \log K)$ time.
2. **Dual-Heap Pattern (Median Maintenance)**: Balance a Max-Heap for the lower half and a Min-Heap for the upper half to retrieve the median in $O(1)$ and insert in $O(\log N)$.
3. **K-Way Merge Pattern**: Maintain a Min-Heap containing the heads of K sorted sequences. Extract min and advance head in $O(N \log K)$.
4. **In-Place Heap Sort**: Build a Max-Heap in $O(N)$ with sift-down, then repeatedly swap root to end and sift-down in $O(N \log N)$ total time and $O(1)$ auxiliary space.

---

## 📝 Problem Summary Table (Day 17 - 7 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P147) | **[LeetCode 215] Kth Largest Element in an Array** | Medium | Min-Heap of size K / Quicksort Partitioning | [KthLargestElementInArray.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/KthLargestElementInArray.java) |
| 2 (P148) | **[LeetCode 347] Top K Frequent Elements** | Medium | Frequency Map + Min-Heap / Bucket Sort | [TopKFrequentElements.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/TopKFrequentElements.java) |
| 3 (P149) | **[LeetCode 295] Find Median from Data Stream** | Hard | Dual Heaps (Max-Heap Lower + Min-Heap Upper) | [FindMedianFromDataStream.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/FindMedianFromDataStream.java) |
| 4 (P150) | **[LeetCode 23] Merge k Sorted Lists** | Hard | Min-Heap PriorityQueue across K Heads | [MergeKSortedListsHeap.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/MergeKSortedListsHeap.java) |
| 5 (P151) | **[LeetCode 973] K Closest Points to Origin** | Medium | Max-Heap of size K (Euclidean Distance) | [KClosestPointsToOrigin.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/KClosestPointsToOrigin.java) |
| 6 (P152) | **[LeetCode 621] Task Scheduler** | Medium | Max-Heap Task Frequencies + Cooldown Queue / Greedy Math | [TaskScheduler.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/TaskScheduler.java) |
| 7 (P153) | **Heap Sort Algorithm** | Medium | In-Place Max-Heapify Sift-Down Sort | [HeapSortAlgorithm.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-09/HeapSortAlgorithm.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day17_HeapsAndPriorityQueue/*.java
java -ea -cp . Day17_HeapsAndPriorityQueue.KthLargestElementInArray
java -ea -cp . Day17_HeapsAndPriorityQueue.TopKFrequentElements
java -ea -cp . Day17_HeapsAndPriorityQueue.FindMedianFromDataStream
java -ea -cp . Day17_HeapsAndPriorityQueue.MergeKSortedListsHeap
java -ea -cp . Day17_HeapsAndPriorityQueue.KClosestPointsToOrigin
java -ea -cp . Day17_HeapsAndPriorityQueue.TaskScheduler
java -ea -cp . Day17_HeapsAndPriorityQueue.HeapSortAlgorithm
```

All 7 files passed all assertion checks cleanly!
