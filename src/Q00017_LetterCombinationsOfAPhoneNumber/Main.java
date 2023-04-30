package Q00017_LetterCombinationsOfAPhoneNumber;

import Q00017_LetterCombinationsOfAPhoneNumber.solutions.IterativeBfsLikeSolution;
import Q00017_LetterCombinationsOfAPhoneNumber.solutions.RecursiveDfsLikeSolution;
import Q00017_LetterCombinationsOfAPhoneNumber.solutions.Solution;
import utils.ListUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                "23",
                Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf")
        );
        runTestCase(
                "",
                new ArrayList<>()
        );
        runTestCase(
                "2",
                Arrays.asList("a","b","c")
        );
    }

    private static void runTestCase(final String input, final List<String> expectedOutput) {
        final List<Solution> solutionOptions = List.of(
                new IterativeBfsLikeSolution(),
                new RecursiveDfsLikeSolution()
        );
        solutionOptions.forEach(solution -> {
            final double startTime = Instant.now().getNano();
            final List<String> actualOutput = solution.letterCombinations(input);
            final double endTime = Instant.now().getNano();

            System.out.println("------------------------------");
            System.out.println("Solution Type: " + solution.solutionDescription());
            System.out.format(
                    "Input = %s. Expected output = %s\n",
                    input,
                    Arrays.toString(expectedOutput.toArray())
            );

            if (ListUtils.stringListsHaveExactlySameItems(expectedOutput, actualOutput)) {
                System.out.format("Correct answer!\n");
            } else {
                System.out.format("Wrong answer. Your answer %s\n", Arrays.toString(actualOutput.toArray()));
            }
            System.out.format("Time Taken: %s ms\n", (endTime - startTime)/1000000);
        });
    }
}