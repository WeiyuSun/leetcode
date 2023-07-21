package src;

public class MaxProduct {

    public int maxProduct(int[] nums){
        int a = maxProductHelper(nums);
        reverse(nums);
        return  Math.max(a, maxProductHelper(nums));
    }
    public int maxProductHelper(int[] nums){
        long magic = Long.MIN_VALUE;
        long currMax = magic;
        long prevMax = magic;
        long total = magic;

        for(int num: nums){
            if(num < 0){
                prevMax = Math.max(prevMax, Math.max(currMax, total));
                total = (total == magic) ? num : total * num;
                currMax = (total > 0) ? total : magic;
            }

            if(num == 0){
                prevMax = Math.max(Math.max(prevMax, 0), Math.max(currMax, total));
                currMax = magic;
                total = magic;
            }

            if(num > 0) {
                currMax = (currMax == magic) ? num : currMax * num;
                total = (total == magic) ? num : total * num;
            }
        }

        return (int)Math.max(prevMax, Math.max(currMax, total));
    }

    private void reverse(int[] nums) {
        for(int i = 0; i < nums.length / 2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1]= temp;
        }
    }
}
