package Q00015_3Sum;

import utils.ListUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[]{ -1, 0, 1, 2, -1, -4 },
                Arrays.asList(
                        Arrays.asList(-1, -1, 2),
                        Arrays.asList(-1, 0, 1)
                )
        );
        runTestCase(
                new int[]{ -2, 0, 1, 1, 2 },
                Arrays.asList(
                        Arrays.asList(-2, 1, 1),
                        Arrays.asList(-2, 0, 2)
                )
        );
    }

    private static void runTestCase(int[] input, List<List<Integer>> expectedOutput) {
        ListUtils.sortDoublyNestedIntegerList(expectedOutput);

        final List<List<Integer>> actualOutput = new Solution().threeSum(input);
        ListUtils.sortDoublyNestedIntegerList(actualOutput);

        System.out.println("------------------------------");
        System.out.format("Input list = %s. Expected output = \"%s\"\n", Arrays.toString(input), expectedOutput);
        if (ListUtils.compareDoublyNestedIntegerList(expectedOutput, actualOutput)) {
            System.out.format("Correct answer!\n");
        } else {
            System.out.format("Wrong answer. Your answer \"%s\"\n", actualOutput);
        }
    }
}