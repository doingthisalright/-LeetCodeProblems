package Q00011_ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int max = 0;

        while (leftPointer < rightPointer) {
            int currentMax = Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer);
            max = Math.max(max, currentMax);

            if (height[leftPointer] > height[rightPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }

        return max;
    }
}