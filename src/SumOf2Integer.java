package src;

public class SumOf2Integer {
    public int getSum(int a, int b) {
        return getSumRec(a, b);
    }

    private int getSumRec(int a, int b){
        int xor = a^b;
        int carry = (a & b) << 1;

        if((xor | carry) != (xor ^ carry)){
            return getSumRec(xor, carry);
        }

        return (xor | carry);
    }
}
