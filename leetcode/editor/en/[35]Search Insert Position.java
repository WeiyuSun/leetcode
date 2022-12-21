/**
 * Given a sorted array of distinct integers and a target value, return the index
 * if the target is found. If not, return the index where it would be if it were
 * inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums contains distinct values sorted in ascending order.
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * Related Topics Array Binary Search 👍 9543 👎 463
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;

            if(nums[mid] > target){
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        r = (0 > r) ? 0 : r;

        return (nums[r] < target) ? r + 1 : r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
