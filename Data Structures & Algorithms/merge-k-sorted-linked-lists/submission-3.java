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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;

        for(int i=0; i<lists.length-1; i++){
            ListNode l1 = lists[i];
            ListNode l2 = lists[i+1];

            ListNode newNode = mergeTwo(l1, l2);
            lists[i+1] = newNode;
        }

        return lists[lists.length-1];

    }

    ListNode mergeTwo(ListNode list1, ListNode list2){
            //merge
            ListNode dummy = new ListNode(0);
            ListNode node = dummy;

            while(list1 != null && list2 != null){
                if(list1.val>=list2.val){
                    node.next = list2;
                    list2 = list2.next;
                }else{
                    node.next = list1;
                    list1 = list1.next;
                }
                node = node.next;
            }

            if (list1 != null) {
                node.next = list1;
            } else {
                node.next = list2;
            }

            return dummy.next;


        }
}
