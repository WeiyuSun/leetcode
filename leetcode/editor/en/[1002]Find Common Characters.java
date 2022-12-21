import java.util.ArrayList;
import java.util.List;

/**
Given a string array words, return an array of all characters that show up in 
all strings within the words (including duplicates). You may return the answer in 
any order. 

 
 Example 1: 
 Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
 
 Example 2: 
 Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 
 
 Constraints: 

 
 1 <= words.length <= 100 
 1 <= words[i].length <= 100 
 words[i] consists of lowercase English letters. 
 

 Related Topics Array Hash Table String 👍 2731 👎 223

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int[] hash = new int[26];
        String temp = words[0];
        int n = temp.length();
        for(int i = 0; i < n; i++){
            char curr = temp.charAt(i);
            hash[curr - 'a']++;
        }

        for(int i = 1; i < words.length; i++){
            int[] hashOthers = new int[26];
            temp = words[i];
            n = temp.length();

            for(int j = 0; j < n; j++){
                char curr = temp.charAt(j);
                hashOthers[curr - 'a']++;
            }

            for(int j = 0; j < 26; j++){
                hash[j] = Math.min(hash[j], hashOthers[j]);
            }
        }

        for(int i = 0; i < 26; i++){
            if(hash[i] > 0){
                for(int j = 0; j < hash[i]; j++){
                    result.add("" + (char)('a' + i));
                }

            }
        }


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
