package Q00020_ValidParentheses;

import Q00020_ValidParentheses.solutions.Solution;
import Q00020_ValidParentheses.solutions.SolutionWithMap;
import Q00020_ValidParentheses.solutions.SolutionWithoutMap;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                "()",
                true
        );
        runTestCase(
                "()[]{}",
                true
        );
        runTestCase(
                "(]",
                false
        );
    }

    private static void runTestCase(final String input, final boolean expectedOutput) {
        final List<Solution> solutionOptions = Arrays.asList(
                new SolutionWithoutMap(),
                new SolutionWithMap()
        );
        solutionOptions.forEach(solution -> {
            final boolean actualOutput = solution.isValid(input);

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format("Input = %s. Expected output = %s\n", input, expectedOutput);
            if (actualOutput == expectedOutput) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", actualOutput);
            }
        });
    }
}