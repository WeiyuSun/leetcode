package src;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        memo[0] = 1;

        int result = Integer.MIN_VALUE;

        for(int i = 0;i < nums.length; i++){
            result = Math.max(result, lengthOfLISRec(nums, memo, i));
        }
        return result;
    }

    private int lengthOfLISRec(int[] nums, int[] memo, int i){
        if(memo[i] != -1){
            return memo[i];
        }

        int result = Integer.MIN_VALUE;
        for(int j = i - 1; j >= 0; j--){
            if(nums[j] < nums[i]){
                result = Math.max(lengthOfLISRec(nums, memo, j) + 1, result) ;
            }
        }

        memo[i] = (result == Integer.MIN_VALUE) ? 1 : result;

        return (result == Integer.MIN_VALUE) ? 1 : result;
    }
}
