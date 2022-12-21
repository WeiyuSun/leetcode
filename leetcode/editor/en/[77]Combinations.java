import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to
 * be the same combination.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * <p>
 * Related Topics Backtracking 👍 5057 👎 164
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        getResultRec(n , k, result, 1, new ArrayList<Integer>());

        return result;
    }

    private void getResultRec(int n, int k, List<List<Integer>> result, int begin, List<Integer> list){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
        }

        for(int i = begin; i <= n; i++){
            list.add(i);
            getResultRec(n, k, result, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
