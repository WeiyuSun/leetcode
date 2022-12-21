/**
 * Write a function that reverses a string. The input string is given as an array
 * of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] is a printable ascii character.
 * <p>
 * <p>
 * Related Topics Two Pointers String 👍 6003 👎 992
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;

        int i = 0;
        int j = s.length - 1;

        while (i <= j){
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
