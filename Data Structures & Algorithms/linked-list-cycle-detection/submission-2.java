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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> vals = new HashSet<>();
        ListNode curr = head;
        boolean flag = false;

        while(curr != null){
            if(vals.contains(curr)){
                flag = true;
                break;
            }
            else{
                vals.add(curr);
            }
            curr = curr.next;
        }

        return flag;
    }
}
