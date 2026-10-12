# 📅 Daily LeetCode & Data Structures Study Log - October 12, 2026

## 🎯 Day 20 Focus: Graph Representation & BFS/DFS

Today's practice covers **7 comprehensive Graph Representation and BFS/DFS problems** in Java, spanning dual adjacency matrix/list representations, breadth-first level order traversal, depth-first branch exploration, connected components counting, tree structure verification, room reachability simulations, and DAG path enumerations.

---

## 💡 Graph Foundations & Traversal Mechanics

1. **Representation Trade-offs**:
   - **Adjacency Matrix**: Space $O(V^2)$, edge check $O(1)$, dense graph optimal.
   - **Adjacency List**: Space $O(V + E)$, neighbor traversal $O(degree(u))$, sparse graph optimal.
2. **Breadth-First Search (BFS)**:
   - Uses an explicit FIFO Queue `ArrayDeque`.
   - Explores concentric circles of distance 0, 1, 2, ... from source.
   - Unweighted graphs: Guarantee of shortest path from source to target.
3. **Depth-First Search (DFS)**:
   - Uses recursive method call frames or an explicit LIFO Stack.
   - Explores full paths to dead-ends before backtracking.
   - Detects cycles in undirected graphs when visiting a previously visited neighbor that is distinct from the immediate parent.
4. **Tree Properties in Undirected Graphs**:
   - A graph of $N$ nodes is a valid tree if and only if:
     1. It contains exactly $N - 1$ edges.
     2. It is connected (a single component).
     3. It has no cycles.

---

## 📝 Problem Summary Table (Day 20 - 7 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P168) | **Graph Representation (Adjacency Matrix & List)** | Medium | Dual Representation, Matrix-to-List Conversion & Degree Lookup | [GraphRepresentationAdjListMatrix.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/GraphRepresentationAdjListMatrix.java) |
| 2 (P169) | **Breadth First Search (BFS)** | Medium | Queue Level Traversal, Shortest Path & Disconnected Components | [BreadthFirstSearchGraph.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/BreadthFirstSearchGraph.java) |
| 3 (P170) | **Depth First Search (DFS)** | Medium | Recursive & Iterative Stack Traversal, Undirected Cycle Detection | [DepthFirstSearchGraph.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/DepthFirstSearchGraph.java) |
| 4 (P171) | **[LeetCode 323] Number of Connected Components in an Undirected Graph** | Medium | Component Exploration via DFS/BFS & Disjoint Set Union | [NumberOfConnectedComponents.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/NumberOfConnectedComponents.java) |
| 5 (P172) | **[LeetCode 261] Graph Valid Tree** | Medium | Acyclic, Connected Tree Verification (N-1 Edges / Union-Find) | [GraphValidTree.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/GraphValidTree.java) |
| 6 (P173) | **[LeetCode 841] Keys and Rooms** | Medium | Directed Graph Reachability Traversal (DFS/BFS) | [KeysAndRooms.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/KeysAndRooms.java) |
| 7 (P174) | **[LeetCode 797] All Paths From Source to Target** | Medium | DAG All Paths Enumeration via Backtracking DFS | [AllPathsFromSourceToTarget.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-12/AllPathsFromSourceToTarget.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day20_GraphRepresentationBFSDFS/*.java
java -ea -cp . Day20_GraphRepresentationBFSDFS.GraphRepresentationAdjListMatrix
java -ea -cp . Day20_GraphRepresentationBFSDFS.BreadthFirstSearchGraph
java -ea -cp . Day20_GraphRepresentationBFSDFS.DepthFirstSearchGraph
java -ea -cp . Day20_GraphRepresentationBFSDFS.NumberOfConnectedComponents
java -ea -cp . Day20_GraphRepresentationBFSDFS.GraphValidTree
java -ea -cp . Day20_GraphRepresentationBFSDFS.KeysAndRooms
java -ea -cp . Day20_GraphRepresentationBFSDFS.AllPathsFromSourceToTarget
```

All 7 files passed all assertion checks cleanly!
