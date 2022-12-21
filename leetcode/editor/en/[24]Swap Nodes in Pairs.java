/**
Given a linked list, swap every two adjacent nodes and return its head. You 
must solve the problem without modifying the values in the list's nodes (i.e., only 
nodes themselves may be changed.) 

 
 Example 1: 
 
 
Input: head = [1,2,3,4]
Output: [2,1,4,3]
 

 Example 2: 

 
Input: head = []
Output: []
 

 Example 3: 

 
Input: head = [1]
Output: [1]
 

 
 Constraints: 

 
 The number of nodes in the list is in the range [0, 100]. 
 0 <= Node.val <= 100 
 

 Related Topics Linked List Recursion 👍 8483 👎 337

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null;
        ListNode returned = second;

        while (first != null && second != null){
            first.next = second.next;
            second.next = first;

            if(prev != null)
                prev.next = second;

            prev = first;

            first = first.next;
            second = (first == null || first.next == null) ? null : first.next;

        }

        return returned;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
