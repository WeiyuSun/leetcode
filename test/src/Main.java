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
        String noSpace = cleanSpace(" this  is    a    good  example   ");
        char[] reversed = reverseString(noSpace);
        System.out.println(new String(reversed));
        int n = reversed.length;
        int start = 0;
        int end;
        for (int i = 0; i < n; i++) {
            if (reversed[i] == ' ' || i == n - 1) {
                reverseWords(reversed, start, (i == n - 1) ? n - 1 : i - 1);
                start = i + 1;
            }
        }

        System.out.println(new String(reversed));
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