package leetcode.editor.en;

import java.awt.datatransfer.FlavorEvent;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * <p>
 * Follow-up: Could you solve the problem in linear time and in
 * O(1) space?
 * <p>
 * Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 11842 👎
 * 378
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /*
        // use hashmap
        int n = nums.length;
        int majorityLen = n / 2;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > majorityLen)
                return num;
        }

        return 0;

         */

        /*
        // use arrays.sort
        Arrays.sort(nums);
        return nums[nums.length / 2];
         */

        // use divide&conquer
        return divideAndConquerRec(nums, 0, nums.length - 1);
    }

    private int divideAndConquerRec(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];

        int mid = l + (r - l) / 2;

        int left = divideAndConquerRec(nums, l, mid);
        int right = divideAndConquerRec(nums, mid + 1, r);

        if (left == right)
            return left;

        int leftCount = 0;
        int rightCount = 0;

        for (int i = l; i <= r; i++) {
            if(nums[i] == left){
                leftCount++;
            }

            if(nums[i] == right) {
                rightCount++;
            }
        }

        return (leftCount > rightCount) ? left : right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
