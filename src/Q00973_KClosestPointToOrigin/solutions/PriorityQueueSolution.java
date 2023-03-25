package Q00973_KClosestPointToOrigin.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueSolution implements Solution {
    public int[][] kClosest(int[][] points, int k) {
        final PriorityQueue<int[]> distancePriorityQueue = new PriorityQueue<>(
                Comparator.comparing(this::euclideanDistance)
        );

        for (int[] point : points) {
            distancePriorityQueue.offer(point);
        }

        final int[][] result = new int[k][];
        for (int loop = 0; loop < k; loop++) {
            result[loop] = distancePriorityQueue.poll();
        }
        return result;
    }

    public String solutionDescription() {
        return "Priority Queue";
    }

    private int euclideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1] ;
    }
}
