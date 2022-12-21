import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
Given an array of integers nums and an integer target, return indices of the 
two numbers such that they add up to target. 

 You may assume that each input would have exactly one solution, and you may 
not use the same element twice. 

 You can return the answer in any order. 

 
 Example 1: 

 
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 

 Example 2: 

 
Input: nums = [3,2,4], target = 6
Output: [1,2]
 

 Example 3: 

 
Input: nums = [3,3], target = 6
Output: [0,1]
 

 
 Constraints: 

 
 2 <= nums.length <= 10⁴ 
 -10⁹ <= nums[i] <= 10⁹ 
 -10⁹ <= target <= 10⁹ 
 Only one valid answer exists. 
 

 
Follow-up: Can you come up with an algorithm that is less than 
O(n²) time complexity?

 Related Topics Array Hash Table 👍 38158 👎 1220

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        int[] result = new int[2];
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int temp = target - nums[i];

            if(table.containsKey(temp)){
                result[0] = i;
                result[1] = table.get(temp);
                return result;
            }

            table.put(nums[i], i);
        }


        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
