import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 * return the number of tuples (i, j, k, l) such that:
 * <p>
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) +
 * 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) +
 * 0 = 0
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸
 * <p>
 * <p>
 * Related Topics Array Hash Table 👍 4265 👎 125
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> table = new HashMap<>();
        int count = 0;

        for (int a : nums1) {
            for (int b : nums2) {
                int temp = a + b;
                if (table.containsKey(temp)) {
                    table.put(temp, table.get(temp) + 1);
                } else {
                    table.put(temp, 1);
                }
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                int temp = c + d;
                if (table.containsKey(-temp)) {
                    count += table.get(-temp);
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
