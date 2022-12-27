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
        System.out.println(isValid(")"));
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int currIndex = 0;
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (curr == '(' || curr == '[' || curr == '{') {
                stack[currIndex] = curr;
                currIndex++;
            } else {
                if(currIndex <= 0)
                    return false;

                if (curr == ')' && stack[currIndex-1] != '(')
                    return false;
                else if (curr == ']' && stack[currIndex-1] != '[')
                    return false;
                else if (curr == '}' && stack[currIndex-1] != '{')
                    return false;

                currIndex--;
            }


        }

        return currIndex == 0;
    }

    private static int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }


    private static void reverseWords(char[] stringArray, int start, int end) {
        int n = end - start;

        char temp;
        for (int i = start; i <= (start + end) / 2; i++) {
            temp = stringArray[i];
            stringArray[i] = stringArray[start + end - i];
            stringArray[start + end - i] = temp;
        }
    }

    private static char[] reverseString(String s) {
        int n = s.length();
        char[] stringArray = new char[n];

        for (int i = 0; i < n; i++) {
            stringArray[i] = s.charAt(i);
        }

        char temp;
        for (int i = 0; i < n / 2; i++) {
            temp = stringArray[i];
            stringArray[i] = stringArray[n - i - 1];
            stringArray[n - i - 1] = temp;
        }

        return stringArray;
    }

    private static String cleanSpace(String s) {
        char prevChar = ' ';
        int start = 0;
        int end = s.length() - 1;
        int n = s.length();
        String spaceCleaned = "";

        while (start < n && s.charAt(start) == ' ')
            start++;
        while (end >= 0 && s.charAt(end) == ' ')
            end--;

        if (start > end)
            return "";

        prevChar = s.charAt(start);
        spaceCleaned += s.charAt(start);
        for (int i = start + 1; i <= end; i++) {
            if (s.charAt(i) == ' ' && prevChar == ' ') {
            } else {
                spaceCleaned += s.charAt(i);
                prevChar = s.charAt(i);
            }
        }
        return spaceCleaned;
    }
}