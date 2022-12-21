import java.util.HashMap;

/**
Given two strings s and t, return true if t is an anagram of s, and false 
otherwise. 

 An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, typically using all the original letters exactly once. 

 
 Example 1: 
 Input: s = "anagram", t = "nagaram"
Output: true
 
 Example 2: 
 Input: s = "rat", t = "car"
Output: false
 
 
 Constraints: 

 
 1 <= s.length, t.length <= 5 * 10⁴ 
 s and t consist of lowercase English letters. 
 

 
 Follow up: What if the inputs contain Unicode characters? How would you adapt 
your solution to such a case? 

 Related Topics Hash Table String Sorting 👍 7500 👎 247

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;

        int[] table = new int[26];

        int n = s.length();
        for(int i = 0; i < n; i++){
            table[(int) (s.charAt(i) - 'a')]++;
        }

        n = t.length();
        for(int i = 0; i < n; i++){
            table[(int) (t.charAt(i) - 'a')]--;
        }

        for(int i: table){
            if(i != 0)
                return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
