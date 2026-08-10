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
    public int goodNodes(TreeNode root) {
        return  dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxV){
        if(root == null) return 0;
        
        int res = 0;
        if(root.val >= maxV) res = 1;
        maxV = Math.max(root.val, maxV);
        res += dfs(root.left, maxV);
        res += dfs(root.right, maxV);
        return res;
        


    }
}
