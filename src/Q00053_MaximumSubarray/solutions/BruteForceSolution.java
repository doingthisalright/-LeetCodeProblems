package Q00053_MaximumSubarray.solutions;

public class BruteForceSolution implements Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int loop1 = 0; loop1 < nums.length; loop1++) {
            int sumSoFar = 0;
            for (int loop2 = loop1; loop2 < nums.length; loop2++) {
                sumSoFar += nums[loop2];
                maxSum = Math.max(maxSum, sumSoFar);
            }
        }
        return maxSum;
    }

    public String solutionDescription() {
        return "Brute Force Solution";
    }
}
