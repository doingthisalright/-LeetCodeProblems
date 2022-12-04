package Q00014_LongestCommonPrefix;

import java.util.Arrays;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new String[]{ "flower", "flow", "flight" },
                "fl"
        );
        runTestCase(
                new String[]{ "dog", "racecar", "car" },
                ""
        );
        runTestCase(
                new String[]{ "hello" },
                "hello"
        );
    }

    private static void runTestCase(String[] input, String expectedOutput) {
        final String actualOutput = new Solution().longestCommonPrefix(input);

        System.out.println("------------------------------");
        System.out.format("Input list = %s. Expected output = \"%s\"\n", Arrays.toString(input), expectedOutput);
        if (expectedOutput.equals(actualOutput)) {
            System.out.format("Correct answer!\n");
        } else {
            System.out.format("Wrong answer. Your answer \"%s\"\n", actualOutput);
        }
    }
}