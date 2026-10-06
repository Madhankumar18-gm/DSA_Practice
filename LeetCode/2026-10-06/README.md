# 📅 Daily LeetCode & Data Structures Study Log - October 06, 2026

## 🎯 Day 14 Focus: Graph Algorithms & Greedy Concepts

Today's practice covers **9 comprehensive Graph & Greedy problems** in Java, spanning graph traversal (BFS/DFS), cycle detection, Dijkstra & Bellman-Ford shortest paths, multi-source BFS propagation, and greedy optimization algorithms.

---

## 💡 Topic Overview: Graph & Greedy Mechanics

Mastering **Graph Algorithms & Greedy Approaches** enables optimal problem solving for connectivity, routing, state-space exploration, and local-choice global optimality in algorithm design.

---

## 📝 Problem Summary Table (Day 14 - 9 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P120) | **[LeetCode 200] Number of Islands** | Medium | Grid BFS Queue & DFS Sink Traversal | [NumberOfIslands.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/NumberOfIslands.java) |
| 2 (P121) | **[LeetCode 133] Clone Graph** | Medium | Graph BFS Queue & Recursive DFS HashMap Cloning | [CloneGraph.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/CloneGraph.java) |
| 3 (P122) | **[LeetCode 207] Course Schedule** | Medium | Kahn's BFS Topological In-Degree & 3-Color DFS Cycle | [CourseSchedule.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/CourseSchedule.java) |
| 4 (P123) | **[LeetCode 743] Network Delay Time** | Medium | Bellman-Ford Edge Relaxation & Dijkstra PriorityQueue | [NetworkDelayTime.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/NetworkDelayTime.java) |
| 5 (P124) | **[LeetCode 994] Rotting Oranges** | Medium | Multi-Source BFS Queue Layer-by-Layer Propagation | [RottingOranges.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/RottingOranges.java) |
| 6 (P125) | **[LeetCode 55] Jump Game** | Medium | Naive Recursive Backtracking & Greedy Max-Reach | [JumpGame.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/JumpGame.java) |
| 7 (P126) | **[LeetCode 134] Gas Station** | Medium | Circular Simulation & Greedy Net Balance Tracking | [GasStation.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/GasStation.java) |
| 8 (P127) | **[LeetCode 455] Assign Cookies** | Easy | Two Pointers Greedily Matching Smallest Satisfying Cookie | [AssignCookies.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/AssignCookies.java) |
| 9 (P128) | **[LeetCode 860] Lemonade Change** | Easy | Greedy Change Dispensing Prioritizing $10 Bills | [LemonadeChange.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-06/LemonadeChange.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day14_GraphAndGreedy/*.java
java -ea -cp . Day14_GraphAndGreedy.NumberOfIslands
java -ea -cp . Day14_GraphAndGreedy.CloneGraph
java -ea -cp . Day14_GraphAndGreedy.CourseSchedule
java -ea -cp . Day14_GraphAndGreedy.NetworkDelayTime
java -ea -cp . Day14_GraphAndGreedy.RottingOranges
java -ea -cp . Day14_GraphAndGreedy.JumpGame
java -ea -cp . Day14_GraphAndGreedy.GasStation
java -ea -cp . Day14_GraphAndGreedy.AssignCookies
java -ea -cp . Day14_GraphAndGreedy.LemonadeChange
```

All 9 files passed all assertion checks cleanly!
