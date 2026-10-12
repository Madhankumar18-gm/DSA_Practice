package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

public class GraphRepresentationAdjListMatrix {

    public static class AdjMatrixGraph {
        private final int vertices;
        private final int[][] matrix;

        public AdjMatrixGraph(int vertices) {
            this.vertices = vertices;
            this.matrix = new int[vertices][vertices];
        }

        public void addEdge(int u, int v, boolean directed) {
            if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
                matrix[u][v] = 1;
                if (!directed) {
                    matrix[v][u] = 1;
                }
            }
        }

        public boolean hasEdge(int u, int v) {
            if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
                return matrix[u][v] == 1;
            }
            return false;
        }

        public int getDegree(int u) {
            int deg = 0;
            for (int v = 0; v < vertices; v++) {
                if (matrix[u][v] == 1) deg++;
            }
            return deg;
        }

        public int[][] getMatrix() {
            return matrix;
        }
    }

    public static class AdjListGraph {
        private final int vertices;
        private final List<List<Integer>> adj;

        public AdjListGraph(int vertices) {
            this.vertices = vertices;
            this.adj = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, boolean directed) {
            if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
                adj.get(u).add(v);
                if (!directed) {
                    adj.get(v).add(u);
                }
            }
        }

        public List<Integer> getNeighbors(int u) {
            return adj.get(u);
        }

        public int getDegree(int u) {
            return adj.get(u).size();
        }

        public static AdjListGraph fromMatrix(int[][] matrix) {
            int n = matrix.length;
            AdjListGraph g = new AdjListGraph(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        g.adj.get(i).add(j);
                    }
                }
            }
            return g;
        }
    }

    public static void main(String[] args) {
        AdjMatrixGraph mat = new AdjMatrixGraph(4);
        mat.addEdge(0, 1, false);
        mat.addEdge(1, 2, false);
        assert mat.hasEdge(0, 1) : "Edge (0,1) exists";
        assert mat.hasEdge(1, 0) : "Edge (1,0) exists";
        assert mat.getDegree(1) == 2 : "Degree of vertex 1 is 2";
        assert !mat.hasEdge(0, 3) : "Edge (0,3) should not exist";

        AdjListGraph list = AdjListGraph.fromMatrix(mat.getMatrix());
        assert list.getNeighbors(1).contains(0) : "List has neighbor 0";
        assert list.getNeighbors(1).contains(2) : "List has neighbor 2";
        assert list.getDegree(1) == 2 : "List degree 2";

        AdjMatrixGraph dirMat = new AdjMatrixGraph(3);
        dirMat.addEdge(0, 1, true);
        assert dirMat.hasEdge(0, 1) : "Directed 0->1";
        assert !dirMat.hasEdge(1, 0) : "Directed 1->0 should be false";

        mat.addEdge(-1, 5, false);
        assert !mat.hasEdge(-1, 5) : "Out of bounds edge query";
    }
}
