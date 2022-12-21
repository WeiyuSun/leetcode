/**
 * Given an array of positive integers nums and a positive integer target, return
 * the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such
 * subarray, return 0 instead.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= target <= 10⁹
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁴
 * <p>
 * <p>
 * <p>
 * Follow up: If you have figured out the
 * O(n) solution, try coding another solution of which the time complexity is
 * O(n log(n)).
 * <p>
 * Related Topics Array Binary Search Sliding Window Prefix Sum 👍 7733 👎 218
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        int n = nums.length;
        int result = n + 1;
        int total = 0;


        while (j < n) {
            total += nums[j];

            while (total >= target) {
                result = Math.min(result, (j - i + 1));
                total -= nums[i];
                i++;
            }


            j += 1;
        }

        return (result == n + 1) ? 0 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
