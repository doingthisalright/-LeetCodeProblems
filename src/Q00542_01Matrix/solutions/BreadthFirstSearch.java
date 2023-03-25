package Q00542_01Matrix.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements Solution {
    public int[][] updateMatrix(int[][] mat) {
        final int[][] allDirections = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        int maxRow = mat.length;
        int maxCol = mat[0].length;

        int[][] dist = new int[maxRow][maxCol];

        final Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (mat[row][col] == 0) {
                    queue.offer(new int[] { row, col });
                    dist[row][col] = 0;
                } else {
                    dist[row][col] = Integer.MAX_VALUE - 100000;
                }
            }
        }

        while (!queue.isEmpty()) {
            final int[] pair = queue.poll();
            final int currentRow = pair[0];
            final int currentCol = pair[1];
            for (final int[] direction : allDirections) {
                int targetRow = currentRow + direction[0];
                int targetCol = currentCol + direction[1];

                if (targetRow >= 0 && targetCol >= 0 && targetRow < maxRow && targetCol < maxCol) {
                    if (dist[targetRow][targetCol] > dist[currentRow][currentCol] + 1) {
                        dist[targetRow][targetCol] = dist[currentRow][currentCol] + 1;
                        queue.add(new int[] { targetRow, targetCol });
                    }
                }
            }
        }

        return dist;
    }

    public String solutionDescription() {
        return "Breadth First Search";
    }
}
