package leetcode.editor.en;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least
 * one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1]
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * <p>
 * Related Topics Array Divide and Conquer Dynamic Programming 👍 24905 👎 1147
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        return dividedAndConquer(nums, 0, nums.length - 1);
    }

    private int dividedAndConquer(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int mid = left + (right - left) / 2;

        int maxLeft = dividedAndConquer(nums, left, mid);
        int maxRight = dividedAndConquer(nums, mid + 1, right);
        int maxCross = cross(nums, left, mid, right);

        return Math.max(maxCross , Math.max(maxLeft, maxRight));
    }

    private int cross(int[] nums, int left, int mid, int right) {
        int maxLeft = 0;
        int maxRight = 0;
        int countLeft = 0;
        int countRight = 0;

        for (int i = mid - 1; i >= left; i--) {
            countLeft += nums[i];
            maxLeft = Math.max(maxLeft, countLeft);
        }

        for (int i = mid + 1; i <= right; i++) {
            countRight += nums[i];
            maxRight = Math.max(countRight, maxRight);
        }

        return maxLeft + maxRight + nums[mid];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
