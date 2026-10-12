package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) return paths;

        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfs(0, graph.length - 1, graph, currentPath, paths);
        return paths;
    }

    private static void dfs(int curr, int target, int[][] graph, List<Integer> currentPath, List<List<Integer>> paths) {
        if (curr == target) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        for (int next : graph[curr]) {
            currentPath.add(next);
            dfs(next, target, graph, currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] g1 = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> res1 = allPathsSourceTarget(g1);
        assert res1.size() == 2 : "Test 1 Size 2";
        assert res1.contains(Arrays.asList(0, 1, 3)) : "Path 0->1->3";
        assert res1.contains(Arrays.asList(0, 2, 3)) : "Path 0->2->3";

        int[][] g2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> res2 = allPathsSourceTarget(g2);
        assert res2.size() == 5 : "Test 2 Size 5 paths";
    }
}
