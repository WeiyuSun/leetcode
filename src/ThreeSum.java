package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 15
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            List<Integer> temp = new ArrayList<>();

            while (left < right) {
                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    temp = new ArrayList<>();
                    left++;
                    right--;
                    continue;
                }

                if (sum < 0) {
                    left++;
                }

                if (sum > 0) {
                    right--;
                }
            }
        }

        return result;
    }
}
