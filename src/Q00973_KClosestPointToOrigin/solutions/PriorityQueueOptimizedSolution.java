package Q00973_KClosestPointToOrigin.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueOptimizedSolution implements Solution {
    public int[][] kClosest(int[][] points, int k) {
        final PriorityQueue<int[]> distancePriorityQueue = new PriorityQueue<>(
                Comparator.comparing(p -> -1 * euclideanDistance(p))
        );

        for (int[] point : points) {
            distancePriorityQueue.offer(point);
            if (distancePriorityQueue.size() > k) {
                distancePriorityQueue.poll();
            }
        }

        final int[][] result = new int[k][];
        for (int loop = 0; loop < k; loop++) {
            result[loop] = distancePriorityQueue.poll();
        }
        return result;
    }

    public String solutionDescription() {
        return "Priority Queue Optimized";
    }

    private int euclideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1] ;
    }
}
