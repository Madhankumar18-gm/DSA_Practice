package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchGraph {

    public static List<Integer> bfsTraversal(int vertices, List<List<Integer>> adj, int start) {
        List<Integer> order = new ArrayList<>();
        if (vertices <= 0 || adj == null || start < 0 || start >= vertices) return order;

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return order;
    }

    public static List<Integer> shortestPath(int vertices, List<List<Integer>> adj, int src, int dest) {
        List<Integer> path = new ArrayList<>();
        if (vertices <= 0 || adj == null || src < 0 || src >= vertices || dest < 0 || dest >= vertices) {
            return path;
        }

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[src] = true;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == dest) break;

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.offer(v);
                }
            }
        }

        if (!visited[dest]) return path; // No path exists

        for (int curr = dest; curr != -1; curr = parent[curr]) {
            path.add(curr);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(2));
        adj.get(2).addAll(Arrays.asList(0, 3));
        adj.get(3).addAll(Arrays.asList(3));

        List<Integer> order = bfsTraversal(4, adj, 2);
        assert order.get(0) == 2 : "Starts with 2";
        assert order.contains(0) && order.contains(3) : "Contains neighbors";

        List<Integer> path = shortestPath(4, adj, 2, 1);
        assert path.get(0) == 2 && path.get(path.size() - 1) == 1 : "Path from 2 to 1";
    }
}
