package Q00973_KClosestPointToOrigin;

import Q00973_KClosestPointToOrigin.solutions.ArraySortSolution;
import Q00973_KClosestPointToOrigin.solutions.PriorityQueueOptimizedSolution;
import Q00973_KClosestPointToOrigin.solutions.PriorityQueueSolution;
import Q00973_KClosestPointToOrigin.solutions.Solution;

import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[][]{
                        { 1, 3 },
                        { -2, -2 },
                },
                1,
                new int[][]{
                        { -2, -2 },
                }
        );
        runTestCase(
                new int[][]{
                        { 3, 3 },
                        { 5, -1 },
                        { -2, -4 },
                },
                2,
                new int[][]{
                        { -2, -4 },
                        { 3, 3 },
                }
        );
    }

    private static void runTestCase(int[][] input, int inputK, int[][] expectedOutput) {
        final List<Solution> solutionOptions = List.of(
                new ArraySortSolution(),
                new PriorityQueueSolution(),
                new PriorityQueueOptimizedSolution()
        );
        solutionOptions.forEach(solution -> {
            final double startTime = Instant.now().getNano();
            final int[][] actualOutput = solution.kClosest(input, inputK);
            final double endTime = Instant.now().getNano();

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format(
                    "Input = %s. Input k = %s. Expected output = %s\n",
                    Arrays.deepToString(input),
                    inputK,
                    Arrays.deepToString(expectedOutput)
            );
            Comparator<int[]> comparator = Comparator.comparing(p -> -1 * (p[0] * p[0] + p[1] * p[1]));
            Arrays.sort(actualOutput, comparator);
            Arrays.sort(expectedOutput, comparator);
            if (Arrays.deepEquals(actualOutput, expectedOutput)) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", Arrays.deepToString(actualOutput));
            }
            System.out.format("Time Taken: %s ms\n", (endTime - startTime)/1000000);
        });
    }
}