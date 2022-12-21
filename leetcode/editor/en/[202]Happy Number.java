import java.util.HashSet;
import java.util.Hashtable;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * <p>
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops
 * endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * <p>
 * <p>
 * Return true if n is a happy number, and false if not.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8² = 100
 * 1² + 0² + 0² = 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 2
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics Hash Table Math Two Pointers 👍 7512 👎 948
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> table = new HashSet<>();

        Integer result = getSum(n);

        while (!table.contains(result)){
            if(result == 1)
                return true;
            table.add(result);
            result = getSum(result);
        }


        return false;
    }

    private Integer getSum(int input) {
        int sum = 0;
        int mod = 0;
        while (input != 0) {
            mod = input % 10;
            sum += (mod * mod);
            input = input / 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
