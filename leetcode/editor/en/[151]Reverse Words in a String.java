/**
Given an input string s, reverse the order of the words. 

 A word is defined as a sequence of non-space characters. The words in s will 
be separated by at least one space. 

 Return a string of the words in reverse order concatenated by a single space. 

 Note that s may contain leading or trailing spaces or multiple spaces between 
two words. The returned string should only have a single space separating the 
words. Do not include any extra spaces. 

 
 Example 1: 

 
Input: s = "the sky is blue"
Output: "blue is sky the"
 

 Example 2: 

 
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

 

 Example 3: 

 
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single 
space in the reversed string.
 

 
 Constraints: 

 
 1 <= s.length <= 10⁴ 
 s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 
 There is at least one word in s. 
 

 
 Follow-up: If the string data type is mutable in your language, can you solve 
it in-place with O(1) extra space? 

 Related Topics Two Pointers String 👍 5202 👎 4438

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        s = cleanSpace(s);
        char[] stringArray = reverseString(s);

        int n = stringArray.length;
        int start = 0;
        for(int i = 0; i < n; i++){
            if(stringArray[i] == ' ' || i == n-1){
                reverseWords(stringArray, start, (i == n - 1) ? n - 1 : i - 1);
                start = i + 1;
            }
        }

        return new String(stringArray);
    }


    private static void reverseWords(char[] stringArray, int start, int end) {
        int n = end - start;

        char temp;
        for(int i = start; i <= (start + end) / 2; i++){
            temp = stringArray[i];
            stringArray[i] = stringArray[start + end - i];
            stringArray[start + end - i] = temp;
        }
    }

    private static char[] reverseString(String s) {
        int n = s.length();
        char[] stringArray = new char[n];

        for(int i = 0; i < n; i++){
            stringArray[i] = s.charAt(i);
        }

        char temp;
        for(int i = 0; i < n/2; i++){
            temp = stringArray[i];
            stringArray[i] = stringArray[n - i - 1];
            stringArray[n-i - 1] = temp;
        }

        return stringArray;
    }

    private static String cleanSpace(String s){
        char prevChar = ' ';
        int start = 0;
        int end = s.length() - 1;
        int n = s.length();
        String spaceCleaned = "";

        while(start < n && s.charAt(start) == ' ')
            start++;
        while (end >= 0 && s.charAt(end) == ' ')
            end--;

        if(start > end)
            return "";

        prevChar = s.charAt(start);
        spaceCleaned += s.charAt(start);
        for(int i = start + 1; i <= end; i++){
            if(s.charAt(i) == ' ' && prevChar == ' ') {
            } else {
                spaceCleaned += s.charAt(i);
                prevChar = s.charAt(i);
            }
        }
        return spaceCleaned;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
