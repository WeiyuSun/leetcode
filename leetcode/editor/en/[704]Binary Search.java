/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists, then
 * return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ < nums[i], target < 10⁴
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 * <p>
 * <p>
 * Related Topics Array Binary Search 👍 6429 👎 137
 */

/*
use binary search to search target value
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;

            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid]< target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
