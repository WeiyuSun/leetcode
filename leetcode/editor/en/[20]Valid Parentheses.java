/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "()"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s consists of parentheses only '()[]{}'.
 * <p>
 * <p>
 * Related Topics String Stack 👍 15797 👎 783
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int currIndex = 0;
        for (int i = 0; i < s.length(); i++) {


            char curr = s.charAt(i);

            if (curr == '(' || curr == '[' || curr == '{') {
                stack[currIndex] = curr;
                currIndex++;
            } else {
                if (currIndex <= 0)
                    return false;
                if (curr == ')' && stack[currIndex - 1] != '(')
                    return false;
                else if (curr == ']' && stack[currIndex - 1] != '[')
                    return false;
                else if (curr == '}' && stack[currIndex - 1] != '{')
                    return false;

                currIndex--;
            }


        }

        return currIndex == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
