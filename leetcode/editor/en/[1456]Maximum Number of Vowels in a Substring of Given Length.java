import java.util.Collection;
import java.util.HashSet;

/**
Given a string s and an integer k, return the maximum number of vowel letters 
in any substring of s with length k. 

 Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'. 

 
 Example 1: 

 
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
 

 Example 2: 

 
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
 

 Example 3: 

 
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

 
 Constraints: 

 
 1 <= s.length <= 10⁵ 
 s consists of lowercase English letters. 
 1 <= k <= s.length 
 

 Related Topics String Sliding Window 👍 850 👎 43

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        int count = 0;
        int result = 0;

        HashSet<Object> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int j = 0;
        int i = 0;
        int n = s.length();

        for (j = 0; j < k; j++) {
            if(vowels.contains(s.charAt(j))){
                count++;
                result++;
            }
        }

        while (j < n) {
            if (vowels.contains(s.charAt(j)))
                count++;

            if (vowels.contains(s.charAt(i)))
                count--;

            if (count == k)
                return count;

            result = Math.max(result, count);
            j++;
            i++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
