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

    public static void main(String[] args) {
        AdjMatrixGraph mat = new AdjMatrixGraph(4);
        mat.addEdge(0, 1, false);
        mat.addEdge(1, 2, false);
        assert mat.hasEdge(0, 1) : "Edge (0,1) exists";
        assert mat.hasEdge(1, 0) : "Edge (1,0) exists";
        assert mat.getDegree(1) == 2 : "Degree of vertex 1 is 2";
        assert !mat.hasEdge(0, 3) : "Edge (0,3) should not exist";
    }
}
