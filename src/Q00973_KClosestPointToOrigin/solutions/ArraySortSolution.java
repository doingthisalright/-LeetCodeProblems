package Q00973_KClosestPointToOrigin.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArraySortSolution implements Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> euclideanDistance(p1) - euclideanDistance(p2));
        return Arrays.copyOfRange(points, 0, k);
    }

    public String solutionDescription() {
        return "Array Sorting";
    }

    private int euclideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1] ;
    }
}
