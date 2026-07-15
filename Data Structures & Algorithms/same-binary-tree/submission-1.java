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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(p);
        st2.push(q);

        while (!st1.isEmpty() && !st2.isEmpty()) {

            TreeNode a = st1.pop();
            TreeNode b = st2.pop();

            if (a.val != b.val)
                return false;

            if ((a.left == null) != (b.left == null))
                return false;

            if ((a.right == null) != (b.right == null))
                return false;

            if (a.right != null) {
                st1.push(a.right);
                st2.push(b.right);
            }

            if (a.left != null) {
                st1.push(a.left);
                st2.push(b.left);
            }
        }

        return st1.isEmpty() && st2.isEmpty();
    }
}
