package Q00542_01Matrix.solutions;

public class DynamicProgramming implements Solution {
    public int[][] updateMatrix(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = mat[0].length;

        int maxDistance = Integer.MAX_VALUE - 100000;

        int[][] dist = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (mat[row][col] == 0) {
                    dist[row][col] = 0;
                } else {
                    dist[row][col] = maxDistance;
                    if (row > 0) {
                        dist[row][col] = Math.min(dist[row][col], dist[row - 1][col] + 1);
                    }
                    if (col > 0) {
                        dist[row][col] = Math.min(dist[row][col], dist[row][col - 1] + 1);
                    }
                }
            }
        }

        for (int row = maxRow - 1; row >= 0; row--) {
            for (int col = maxCol - 1; col >= 0; col--) {
                if (row < maxRow - 1) {
                    dist[row][col] = Math.min(dist[row][col], dist[row + 1][col] + 1);
                }
                if (col < maxCol - 1) {
                    dist[row][col] = Math.min(dist[row][col], dist[row][col + 1] + 1);
                }
            }
        }

        return dist;
    }

    public String solutionDescription() {
        return "Dynamic Programming";
    }
}
