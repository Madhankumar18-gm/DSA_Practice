package Day14_GraphAndGreedy;

import java.util.Arrays;

public class NetworkDelayTime {
    public static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static int networkDelayTimeBellmanFord(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int[] edge : times) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
