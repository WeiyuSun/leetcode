import java.util.Arrays;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0
 * ,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0
 * ,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0
 * ,9]. 8 is the missing number in the range since it does not appear in nums.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 10⁴
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space
 * complexity and O(n) runtime complexity?
 * <p>
 * Related Topics Array Hash Table Math Binary Search Bit Manipulation Sorting 👍
 * 7471 👎 2978
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
//        // sorting
//        Arrays.sort(nums);
//        int n = nums.length;
//        for(int i = 0 ; i < n; i++){
//            if(i != nums[i])
//                return i;
//        }
//
//        return n;

        // use key-value pair
//        int n = nums.length;
//        boolean[] isExit = new boolean[n];
//
//        for (int num : nums) {
//            if (num < n)
//                isExit[num] = true;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!isExit[i]) {
//                return i;
//            }
//        }
//
//        return n;

        // sum
        int n = nums.length;

        int sumFirstN = n * ( n + 1) / 2;
        int actualSum = 0;
        for(int num: nums){
            actualSum += num;
        }

        return sumFirstN - actualSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
