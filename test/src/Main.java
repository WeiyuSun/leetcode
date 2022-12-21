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
        System.out.println(reverseStr("abcdefgh", 2));
    }
    public static String reverseStr(String s, int k) {
        k = Math.min(k, s.length());
        char[] chars = s.toCharArray();
        char temp;
        for(int i = 0; i < k/2; i++){
            temp = chars[i];
            chars[i] = s.charAt(k - i - 1);
            chars[k - i - 1] = temp;
        }

        return new String(chars);
    }
}