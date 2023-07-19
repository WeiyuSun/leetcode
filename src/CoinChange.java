package src;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return coinChangeRec(coins, amount, memo);
    }

    private int coinChangeRec(int[] coins, int amount, int[] memo) {
        if(amount < 0){
            return -1;
        }

        if(amount == 0){
            return 0;
        }

        if(memo[amount] != -2){
            return memo[amount];
        }

        int result = Integer.MAX_VALUE;
        for(int coin: coins) {
            int temp = coinChangeRec(coins, amount - coin, memo);

            if(temp < 0){
                continue;
            }

            result = Math.min(temp + 1, result);
        }

        if(result ==  Integer.MAX_VALUE){
            memo[amount] = -1;
        } else {
            memo[amount] = result;
        }

        return memo[amount];
    }
}
