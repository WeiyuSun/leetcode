package leetcode.editor.en; /**
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos is
 * used to denote the index of the node that tail's next pointer is connected to (0-
 * indexed). It is -1 if there is no cycle. Note that pos is not passed as a
 * parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of the nodes in the list is in the range [0, 10⁴].
 * -10⁵ <= Node.val <= 10⁵
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * <p>
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * Related Topics Hash Table Linked List Two Pointers 👍 9408 👎 661
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                temp = slow;
                break;
            }
        }

        slow = head;
        if(temp != null){
            while (slow != temp){
                slow = slow.next;
                temp = temp.next;
            }
        }

        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
