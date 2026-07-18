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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return list;

        q.offer(root);

        while(!q.isEmpty()){
            int length = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =0; i<length; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                temp.add(curr.val);
            }

            list.add(temp);
        }

        return list;
    }
}
