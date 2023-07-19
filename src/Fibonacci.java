package src;

import java.util.HashMap;

public class Fibonacci {
    public long fib(int num){
        return fibRec(num, new HashMap<>());
    }

    private long fibRec(int num, HashMap<Integer, Long> mem){
        if(num == 0){
            return 0;
        }

        if(num == 1 || num == 2){
            return 1;
        }

        if(mem.get(num) != null){
            return mem.get(num);
        }

        long result = fibRec(num - 1, mem) + fibRec(num - 2, mem);
        mem.put(num, result);

        return result;
    }
}
