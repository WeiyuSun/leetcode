/**
 * Given the head of a linked list, remove the nᵗʰ node from the end of the list
 * and return its head.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Related Topics Linked List Two Pointers 👍 13739 👎 569
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        for(int i = 0; i < n; i++)
            fast = fast.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
