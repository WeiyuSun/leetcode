/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high]
 * .
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [1, 2 * 10⁴].
 * 1 <= Node.val <= 10⁵
 * 1 <= low <= high <= 10⁵
 * All Node.val are unique.
 * <p>
 * <p>
 * Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 4672 ?
 * ? 337
 */

//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int result = 0;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                if (pNode.val >= low && pNode.val <= high) {
                    result += pNode.val;
                }

                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode temp = stack.pop();

                pNode = temp.right;
            }
        }

        return result;
    }

    // recursion
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        if (root == null) return 0;
//        int sum = 0;
//        if (root.val >= low && root.val <= high) sum += root.val;
//        if (root.val > low) sum += rangeSumBST(root.left, low, high);
//        if (root.val < high) sum += rangeSumBST(root.right, low, high);
//
//        return sum;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
