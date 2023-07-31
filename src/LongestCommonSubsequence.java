package src;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ezupkr", "ubmrapg"));
    }

    // loop
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    memo[i+1][j+1] = memo[i][j] + 1;
                } else {
                    memo[i+1][j+1] = Math.max(memo[i + 1][j], memo[i][j+1]);
                }
            }
        }

        return memo[text1.length()][text2.length()];
    }
    // recursive
//    public static int longestCommonSubsequence(String text1, String text2) {
//        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
//
//        for(int[] token : memo){
//            Arrays.fill(token, -1);
//        }
//
//        return longestCommonSubsequenceRec(text1, text2, memo, text1.length() - 1, text2.length() - 1);
//    }
//
//    public static int longestCommonSubsequenceRec(String source, String target, int[][] memo, int i, int j){
//        if(i < 0 || j < 0){
//            return 0;
//        }
//
//        if(memo[i][j] != -1){
//            return memo[i][j];
//        }
//
//        int result = Integer.MIN_VALUE;
//        char currS = source.charAt(i);
//        char currT = target.charAt(j);
//        if(currS == currT){
//            result = longestCommonSubsequenceRec(source, target, memo, i - 1, j - 1) + 1;
//        } else {
//            result = Math.max(longestCommonSubsequenceRec(source, target, memo, i - 1, j), longestCommonSubsequenceRec(source, target, memo, i, j - 1));
//        }
//
//        memo[i][j] = result;
//
//        return result;
//    }
}
