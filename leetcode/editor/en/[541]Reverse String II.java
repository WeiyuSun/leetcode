/**
Given a string s and an integer k, reverse the first k characters for every 2k 
characters counting from the start of the string. 

 If there are fewer than k characters left, reverse all of them. If there are 
less than 2k but greater than or equal to k characters, then reverse the first k 
characters and leave the other as original. 

 
 Example 1: 
 Input: s = "abcdefg", k = 2
Output: "bacdfeg"
 
 Example 2: 
 Input: s = "abcd", k = 2
Output: "bacd"
 
 
 Constraints: 

 
 1 <= s.length <= 10⁴ 
 s consists of only lowercase English letters. 
 1 <= k <= 10⁴ 
 

 Related Topics Two Pointers String 👍 1382 👎 2922

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i += 2*k){
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);

            while (start < end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
        }

        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
