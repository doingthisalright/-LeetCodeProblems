package Q00542_01Matrix;

import Q00542_01Matrix.solutions.BreadthFirstSearch;
import Q00542_01Matrix.solutions.BruteForce;
import Q00542_01Matrix.solutions.DynamicProgramming;
import Q00542_01Matrix.solutions.Solution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[][]{
                        { 0, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 0 },
                },
                new int[][]{
                        { 0, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 0 },
                }
        );
        runTestCase(
                new int[][]{
                        { 0, 0, 0 },
                        { 0, 1, 0 },
                        { 1, 1, 1 },
                },
                new int[][]{
                        { 0, 0, 0 },
                        { 0, 1, 0 },
                        { 1, 2, 1 },
                }
        );
    }

    private static void runTestCase(int[][] input, int[][] expectedOutput) {
        final List<Solution> solutionOptions = List.of(
                new BruteForce(),
                new BreadthFirstSearch(),
                new DynamicProgramming()
        );
        solutionOptions.forEach(solution -> {
            final int[][] actualOutput = solution.updateMatrix(input);

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format(
                    "Input = %s. Expected output = %s\n",
                    Arrays.deepToString(input),
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