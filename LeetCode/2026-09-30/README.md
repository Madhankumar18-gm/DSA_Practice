# 📅 Daily LeetCode & Data Structures Study Log - September 30, 2026

## 🎯 Day 10 Focus: Queue & Deque Concepts

Today's practice covers **9 comprehensive Queue & Deque problems** in Java, spanning circular queue design, circular deque design, sliding window time frame counter, stream deduplication, queue segment reversal, deck ordering simulation, preference rotation, queue interleaving, and level-by-level binary string generation.

---

## 💡 Topic Overview: Queue & Deque Mechanics

A **Queue** is a FIFO (First-In-First-Out) data structure supporting $O(1)$ `enqueue` (offer) at the rear and `dequeue` (poll) at the front.
A **Deque** (Double-Ended Queue) supports $O(1)$ insertions and deletions at both ends (`front` and `rear`).

### Key Advantages & Patterns:
1. **Circular Array Ring Buffer**: Using modulo arithmetic `(index + 1) % capacity` allows continuous $O(1)$ queue and deque operations within fixed memory array allocation.
2. **Sliding Window Time Eviction**: Maintaining elements ordered by arrival time enables $O(1)$ amortized eviction of stale elements outside the sliding time frame (e.g. `t - 3000ms`).
3. **Queue + Auxiliary Stack**: Utilizing a Stack alongside a Queue facilitates segment reversals (first $K$ elements) and interleaving algorithms.

---

## 📝 Problem Summary Table (Day 10 - 9 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P84) | **[LeetCode 622] Design Circular Queue** | Medium | Array Ring Buffer, Modulo Indexing | [DesignCircularQueue.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/DesignCircularQueue.java) |
| 2 (P85) | **[LeetCode 641] Design Circular Deque** | Medium | Double-Ended Circular Ring Buffer | [DesignCircularDeque.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/DesignCircularDeque.java) |
| 3 (P86) | **[LeetCode 933] Number of Recent Calls** | Easy | Queue Sliding Window Eviction | [NumberOfRecentCalls.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/NumberOfRecentCalls.java) |
| 4 (P87) | **First Non-Repeating Character in a Stream** | Medium | Real-Time Queue & Frequency Array | [FirstNonRepeatingCharacterInStream.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/FirstNonRepeatingCharacterInStream.java) |
| 5 (P88) | **Reverse First K Elements of Queue** | Medium | Queue + Auxiliary Stack Reversal | [ReverseFirstKElementsOfQueue.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/ReverseFirstKElementsOfQueue.java) |
| 6 (P89) | **[LeetCode 950] Reveal Cards In Increasing Order** | Medium | Index Queue Deck Simulation | [RevealCardsInIncreasingOrder.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/RevealCardsInIncreasingOrder.java) |
| 7 (P90) | **[LeetCode 1700] Number of Students Unable to Eat Lunch** | Easy | Preference Matching & Deadlock Count | [NumberOfStudentsUnableToEatLunch.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/NumberOfStudentsUnableToEatLunch.java) |
| 8 (P91) | **Interleave First Half of Queue with Second Half** | Medium | Half-Queue Stack Interleaving | [InterleaveQueueHalves.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/InterleaveQueueHalves.java) |
| 9 (P92) | **Generate Binary Numbers from 1 to N using Queue** | Medium | Level-by-Level Queue BFS Extension | [GenerateBinaryNumbersUsingQueue.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-30/GenerateBinaryNumbersUsingQueue.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day10_Queue/*.java
java -ea -cp . Day10_Queue.DesignCircularQueue
java -ea -cp . Day10_Queue.DesignCircularDeque
java -ea -cp . Day10_Queue.NumberOfRecentCalls
java -ea -cp . Day10_Queue.FirstNonRepeatingCharacterInStream
java -ea -cp . Day10_Queue.ReverseFirstKElementsOfQueue
java -ea -cp . Day10_Queue.RevealCardsInIncreasingOrder
java -ea -cp . Day10_Queue.NumberOfStudentsUnableToEatLunch
java -ea -cp . Day10_Queue.InterleaveQueueHalves
java -ea -cp . Day10_Queue.GenerateBinaryNumbersUsingQueue
```

All 9 files passed all assertion checks cleanly!
