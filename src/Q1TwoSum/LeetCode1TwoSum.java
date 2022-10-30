package Q1TwoSum;

import java.util.Arrays;

public class LeetCode1TwoSum {
    public static void main(String[] args) {
        final int[] nums = { 2, 7, 11, 15 };
        final int target = 9;
        final int[] result = new Solution().optimalAndShorter(nums, target);

        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("target: " + target);

        System.out.println("\nresponse: " + Arrays.toString(result));
        System.out.println("expected: [0, 1]");
        if (nums[result[0]] + nums[result[1]] != target) {
            System.out.printf(
                    "%nWrong answer.%n%s + %s is %s.%nExpected %s + %s = %s%n",
                    nums[result[0]],
                    nums[result[1]],
                    nums[result[0]] + nums[result[1]],
                    nums[0],
                    nums[1],
                    target
            );
        } else {
            System.out.println("\nCorrect answer!");
        }
    }
}
