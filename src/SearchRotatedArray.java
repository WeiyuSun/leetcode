package src;

public class SearchRotatedArray {

    public int search(int[] nums, int target){
        if(target == nums[0]) {
            return 0;
        }

        int minIndex = findMinRec(nums, 0, nums.length - 1);

        if(minIndex == 0) {
            return findTargetRec(nums, 0, nums.length - 1, target);
        }

        if(target > nums[0]){
            return findTargetRec(nums, 0, minIndex - 1, target);
        }

        return findTargetRec(nums, minIndex, nums.length - 1, target);
    }

    private int findTargetRec(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;

        if(nums[mid] == target) {
            return mid;
        }

        if(left >= right) {
            return -1;
        }



        if(target < nums[mid]){
            return findTargetRec(nums, left, mid -1, target);
        }

        return findTargetRec(nums, mid + 1, right, target);
    }

    private int findMinRec(int[] nums, int left, int right){
        if(left == right){
            return left;
        }

        int mid = (left + right) / 2;

        if (nums[right] > nums[mid]) {
            return findMinRec(nums, left, mid);
        }

        return findMinRec(nums, mid + 1, right);
    }
}


