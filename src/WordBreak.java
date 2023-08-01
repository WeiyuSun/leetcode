package src;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    // 139
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;

        return helper(s, wordDict, s.length(), memo) == 1;
    }

    private static int helper(String s, List<String> wordDict, int index, int[] memo) {
        if (memo[index] != 0) {
            return memo[index];
        }

        int result = -1;
        for (String dict : wordDict) {
            int n = dict.length();
            if (n > index) {
                continue;
            }

            result = helper(s, wordDict, index - n, memo);
            if (result == 1 && dict.contains(s.substring(index - n, index))) {
                break;
            }

            result = -1;
        }

        memo[index] = result;
        return result;
    }
}
