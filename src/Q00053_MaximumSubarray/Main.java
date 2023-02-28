package Q00053_MaximumSubarray;

import Q00053_MaximumSubarray.solutions.Solution;
import Q00053_MaximumSubarray.solutions.BruteForceSolution;
import Q00053_MaximumSubarray.solutions.OptimalSolution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[]{ -2, 1, -3, 4, -1, 2, 1, -5, 4 },
                6
        );
        runTestCase(
                new int[]{ 1 },
                1
        );
        runTestCase(
                new int[]{ 5, 4, -1, 7, 8 },
                23
        );
    }

    private static void runTestCase(int[] input, int expectedOutput) {
        final List<Solution> solutionOptions = Arrays.asList(
                new BruteForceSolution(),
                new OptimalSolution()
        );
        solutionOptions.forEach(solution -> {
            final int actualOutput = solution.maxSubArray(input);

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format("Input = %s. Expected output = %s\n", Arrays.toString(input), expectedOutput);
            if (actualOutput == expectedOutput) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", actualOutput);
            }
        });
    }
}