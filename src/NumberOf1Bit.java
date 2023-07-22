package src;

public class NumberOf1Bit {
    public int hammingWeight(int n) {
        int count = 0;
        // 191
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }

        return count;
    }
}
