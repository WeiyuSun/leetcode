import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.*;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString() {
        return "" + val;
    }
}

public class Main {

    //    测试用例:["MyLinkedList","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtTail"]
//            [[],              [0],        [1,4],      [8],            [5],        [4,3],      [0],        [5],        [6,3],      [7],            [5],            [4]]
    public static void main(String[] args) {
        System.out.println(getSum(82));
    }
    private static int getSum(int input){
        int sum = 0;
        int mod = 0;
        while (input != 0){
            mod = input % 10;
            sum += (mod * mod);
            input = input / 10;
        }

        return sum;
    }
}