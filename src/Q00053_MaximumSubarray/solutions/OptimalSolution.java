package Q00053_MaximumSubarray.solutions;

public class OptimalSolution implements Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public String solutionDescription() {
        return "Single Iteration Optimal Solution";
    }
}
