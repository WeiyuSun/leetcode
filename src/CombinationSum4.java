package src;

import java.util.Arrays;

public class CombinationSum4{

        public int combinationSum4(int[] nums, int target) {
            // 377
            int[] memo = new int[target + 1];
            Arrays.fill(memo, -1);
            memo[0] = 1;

            return helper(nums, target, memo);
        }

        private int helper(int[] nums, int target, int[] memo) {
            if (memo[target] != -1) {
                return memo[target];
            }

            int result = 0;

            for (int num : nums) {
                if (target - num < 0) {
                    continue;
                }

                result += helper(nums, target - num, memo);
            }

            memo[target] = result;
            return result;
        }
}
