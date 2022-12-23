/**
Given two strings needle and haystack, return the index of the first occurrence 
of needle in haystack, or -1 if needle is not part of haystack. 

 
 Example 1: 

 
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
 

 Example 2: 

 
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

 
 Constraints: 

 
 1 <= haystack.length, needle.length <= 10⁴ 
 haystack and needle consist of only lowercase English characters. 
 

 Related Topics Two Pointers String String Matching 👍 1112 👎 85

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int j = 0;
        int i = 0;
        while (i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(j == needle.length() - 1){
                    return i - j;
                }
                i++;
                j++;
            }else {
                if(j == 0){
                    i++;
                } else {
                    j = next[j-1];
                }
            }
        }

        return -1;
    }

    private int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
