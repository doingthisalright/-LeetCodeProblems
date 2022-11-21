package Q00011_ContainerWithMostWater;

import java.util.Arrays;

public class Main {
    public static void main(final String[] args) {
        runTestCase(
                new int[]{ 1, 8, 6, 2, 5, 4, 8, 3, 7 },
                49
        );
        runTestCase(
                new int[]{ 1, 1 },
                1
        );
    }

    private static void runTestCase(int[] input, int expectedOutput) {
        final int actualOutput = new Solution().maxArea(input);

        System.out.println("------------------------------");
        System.out.format("Input list = %s. \nExpected output = %s\n", Arrays.toString(input), expectedOutput);
        if (actualOutput == expectedOutput) {
            System.out.format("Correct answer!\n");
        } else {
            System.out.format("Wrong answer. \nYour answer %s\n", actualOutput);
        }
    }
}