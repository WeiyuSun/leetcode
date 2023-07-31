package src;

public class ClimbingStairs {
    public int climbStairs(int n) {
        //70
        int[] memo = new int[n + 1];

        return climbStairsRec(n, memo);
    }

    private int climbStairsRec(int n, int[] memo){
        if(n <= 3){
            return n;
        }

        if(memo[n] != 0){
            return memo[n];
        }

        int result =  climbStairsRec(n - 1, memo) + climbStairsRec(n - 2, memo);
        memo[n] = result;

        return result;
    }
}
