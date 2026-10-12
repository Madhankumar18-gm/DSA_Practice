package Day20_GraphRepresentationBFSDFS;

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
    }
}
