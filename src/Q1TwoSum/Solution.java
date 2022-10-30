package Q1TwoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] optimalAndShorter(int[] nums, int target) {
        final Map<Integer, Integer> numsMap = new HashMap<>();
        for (int loop = 0; loop < nums.length; loop++) {
            final Integer indexOfTheValueToSearch = numsMap.get(target - nums[loop]);

            if (indexOfTheValueToSearch != null) {
                return new int[]{ loop, indexOfTheValueToSearch};
            } else {
                numsMap.put(nums[loop], loop);
            }
        }

        return null;
    }

    public int[] optimal(int[] nums, int target) {
        int index1 = -1;
        int index2 = -1;

        final Map<Integer, Integer> numsMap = new HashMap<>();
        for (int loop = 0; loop < nums.length; loop++) {
            final int currentValue = nums[loop];
            numsMap.put(currentValue, loop);
        }

        for (int loop = 0; loop < nums.length; loop++) {
            final int currentValue = nums[loop];
            final int valueToSearch = target - currentValue;

            if (numsMap.containsKey(valueToSearch)) {
                final int indexOfTheValueToSearch = numsMap.get(valueToSearch);
                if (indexOfTheValueToSearch != loop) {
                    index1 = loop;
                    index2 = indexOfTheValueToSearch;
                    break;
                }
            }
        }

        return new int[]{ index1, index2};
    }

    public int[] bruteForce(int[] nums, int target) {
        int index1 = -1;
        int index2 = -1;
        for (int loop1 = 0; loop1 < nums.length; loop1++) {
            for (int loop2 = 0; loop2 < nums.length; loop2++) {
                if (loop1 == loop2) {
                    continue;
                }
                if (nums[loop1] + nums[loop2] == target) {
                    index1 = loop1;
                    index2 = loop2;
                    break;
                }
            }
        }
        return new int[]{ index1, index2 };
    }
}