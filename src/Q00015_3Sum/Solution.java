package Q00015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final Set<List<Integer>> result  = new HashSet<>();

        if (nums.length == 0) {
            return new ArrayList<>(result);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {
                long sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));

                    int lastLeft = nums[leftPointer];
                    int lastRight = nums[rightPointer];
                    while (leftPointer < rightPointer && lastLeft == nums[leftPointer]) {
                        leftPointer++;
                    }

                    while (leftPointer < rightPointer && lastRight == nums[rightPointer]) {
                        rightPointer--;
                    }
                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum_bruteForce(int[] nums) {
        final Map<String, List<Integer>> result = new HashMap<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        final List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        result.put(list.toString(), list);
                    }
                }
            }
        }

        return new ArrayList<>(result.values());
    }
}