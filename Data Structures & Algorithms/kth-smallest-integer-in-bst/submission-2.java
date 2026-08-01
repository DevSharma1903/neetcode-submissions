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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        List<Integer> arr = levelTrav(root);

        arr = levelTrav(root);
        return arr.get(k-1);
    }

    public List<Integer> levelTrav(TreeNode root){
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;

        while(true){
            if(node != null){
                s.push(node);
                node = node.left;
            }
            else{
                if(s.isEmpty()) break;
                node = s.pop();
                arr.add(node.val);
                node = node.right;
            }
        }

        return arr;
    }
}
