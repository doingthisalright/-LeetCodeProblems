package Q00057_InsertInterval;

import Q00057_InsertInterval.solutions.OptimalSolution;
import Q00057_InsertInterval.solutions.Solution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[][]{
                        { 1, 3 },
                        { 6, 9 },
                },
                new int[]{ 2, 5 },
                new int[][]{
                        { 1, 5 },
                        { 6, 9 },
                }
        );
        runTestCase(
                new int[][]{
                        { 1, 2 },
                        { 3, 5 },
                        { 6, 7 },
                        { 8, 10 },
                        { 12, 16 },
                },
                new int[]{ 4, 8 },
                new int[][]{
                        { 1, 2 },
                        { 3, 10 },
                        { 12, 16 },
                }
        );
    }

    private static void runTestCase(int[][] intervals, int[] newInterval, int[][] expectedOutput) {
        final List<Solution> solutionOptions = List.of(
                new OptimalSolution()
        );
        solutionOptions.forEach(solution -> {
            final int[][] actualOutput = solution.insert(intervals, newInterval);

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format(
                    "Input Interval = %s.\nInput Insert Interval = %s.\nExpected output = %s\n",
                    Arrays.deepToString(intervals),
                    Arrays.toString(newInterval),
                    Arrays.deepToString(expectedOutput)
            );
            if (Arrays.deepEquals(actualOutput, expectedOutput)) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", Arrays.deepToString(actualOutput));
            }
        });
    }
}