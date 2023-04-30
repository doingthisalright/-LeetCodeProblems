package Q00121_BestTimeToBuyAndSellStock;

import Q00121_BestTimeToBuyAndSellStock.solutions.Solution;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[]{ 7,1,5,3,6,4 },
                5
        );
        runTestCase(
                new int[]{ 7,6,4,3,1 },
                0
        );
    }

    private static void runTestCase(int[] input, int expectedOutput) {
        final List<Solution> solutionOptions = List.of(
                new Solution()
        );
        solutionOptions.forEach(solution -> {
            final double startTime = Instant.now().getNano();
            final int actualOutput = solution.maxProfit(input);
            final double endTime = Instant.now().getNano();

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format(
                    "Input = %s. Expected output = %s\n",
                    Arrays.toString(input),
                    expectedOutput
            );

            if (actualOutput == expectedOutput) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", actualOutput);
            }
            System.out.format("Time Taken: %s ms\n", (endTime - startTime)/1000000);
        });
    }
}