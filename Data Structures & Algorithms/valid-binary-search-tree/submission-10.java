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
    public boolean isValidBST(TreeNode root) {
        int up = Integer.MAX_VALUE;
        int low = Integer.MIN_VALUE;
        return dfs(root, up, low);
    }

    public boolean dfs(TreeNode node, int up, int low) {
        if (node == null) {
            return true;
        }

        if (node.val <= low || node.val >= up) {
            return false;
        }

        if (!dfs(node.left, node.val, low)) {
            return false;
        }

        if (!dfs(node.right, up, node.val)) {
            return false;
        }

        return true;
    }
}
