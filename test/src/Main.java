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
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int stackIndex = 0;
        for(int i = 0; i < n; i++){
            char currChar = s.charAt(i);

            if(stackIndex == 0 || stack[stackIndex - 1] != currChar){
                stack[stackIndex++] = currChar;
            } else if(stack[stackIndex - 1] == currChar){
                stackIndex--;
            }
        }

        String result = new String(stack, 0, stackIndex);
        return result;
    }
}