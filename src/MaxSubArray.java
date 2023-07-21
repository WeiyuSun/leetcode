package src;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int temp = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(result < 0 && nums[i] > result){
                result = nums[i];
            }

            if(temp < 0 && nums[i] > temp) {
                temp = nums[i];
            } else {
                temp += nums[i];           }

            if(temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
