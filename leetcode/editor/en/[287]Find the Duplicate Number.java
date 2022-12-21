package leetcode.editor.en;

import java.util.HashMap;
import java.util.Hashtable;

/**
Given an array of integers nums containing n + 1 integers where each integer is 
in the range [1, n] inclusive. 

 There is only one repeated number in nums, return this repeated number. 

 You must solve the problem without modifying the array nums and uses only 
constant extra space. 

 
 Example 1: 

 
Input: nums = [1,3,4,2,2]
Output: 2
 

 Example 2: 

 
Input: nums = [3,1,3,4,2]
Output: 3
 

 
 Constraints: 

 
 1 <= n <= 10⁵ 
 nums.length == n + 1 
 1 <= nums[i] <= n 
 All the integers in nums appear only once except for precisely one integer 
which appears two or more times. 
 

 
 Follow up: 

 
 How can we prove that at least one duplicate number must exist in nums? 
 Can you solve the problem in linear runtime complexity? 
 

 Related Topics Array Two Pointers Binary Search Bit Manipulation 👍 16517 👎 21
86

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // mapping
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        boolean[] isExist = new boolean[nums.length];

        for(int num: nums){
            if(!isExist[num])
                isExist[num] = true;
            else
                return num;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
