package Q00542_01Matrix.solutions;

public class BruteForce implements Solution {
    public int[][] updateMatrix(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = mat[0].length;

        int[][] dist = new int[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (mat[row][col] == 0) {
                    dist[row][col] = 0;
                } else {
                    dist[row][col] = Integer.MAX_VALUE;
                    for (int rowLoop = 0; rowLoop < maxRow; rowLoop++) {
                        for (int colLoop = 0; colLoop < maxCol; colLoop++) {
                            if (mat[rowLoop][colLoop] == 0) {
                                int distance = Math.abs(rowLoop - row) + Math.abs(colLoop - col);
                                dist[row][col] = Math.min(dist[row][col], distance);
                            }
                        }
                    }
                }
            }
        }

        return dist;
    }

    public String solutionDescription() {
        return "Brute Force";
    }
}
