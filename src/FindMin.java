package src;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        return findMinRec(nums, left, right);
    }

    private int findMinRec(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }

        int mid = (left + right) / 2;

        if (nums[right] > nums[mid]) {
            return findMinRec(nums, left, mid);
        }

        return findMinRec(nums, mid + 1, right);
    }
}
