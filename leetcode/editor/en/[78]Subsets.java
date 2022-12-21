import org.omg.CORBA.OMGVMCID;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (
 * the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * <p>
 * <p>
 * Related Topics Array Backtracking Bit Manipulation 👍 12010 👎 172
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // extension method
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> element = new ArrayList<>();
//        result.add(element);
//        int listSize;
//        for (int num : nums) {
//            listSize = result.size();
//            for (int j = 0; j < listSize; j++) {
//                List<Integer> temp = result.get(j);
//                element = new ArrayList<>(temp);
//                element.add(num);
//                result.add(element);
//            }
//        }
//
//        return result;
//    }

    private int n;
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null)
            return null;


        if(nums.length == 0)
            new ArrayList<>();

        n = nums.length;

        getSubsetsRec();
    }

    private void getSubsetsRec(int start, int k, List<Integer> cur, int[] nums){
        if(k == 0){
            result.add(cur);
            return;
        }

        for(int i = start; i < n; i++){
            cur.add(i);
            getSubsetsRec(start + 1, k - 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
