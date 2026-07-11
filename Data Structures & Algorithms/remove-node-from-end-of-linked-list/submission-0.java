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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //reverse
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        //nth node
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode curr = prev;

        for(int i=0; i<=n-2; i++){
            node.next = curr;
            curr = curr.next;
            node = node.next;
        }

        node.next = curr.next;
        
        ListNode previous = null;
        ListNode current_new = dummy.next;
        while(current_new != null){
            ListNode temp = current_new.next;
            current_new.next = previous;
            previous = current_new;
            current_new = temp;
        }

        return previous;
    }
}
