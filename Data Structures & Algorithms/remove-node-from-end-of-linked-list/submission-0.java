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
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode left = dummy;
        ListNode ryt=dummy.next;

        for(int i=0;i<n;i++){
            ryt=ryt.next;
        }

        while(ryt!=null){
            left=left.next;
            ryt=ryt.next;
        }
        ListNode dum=left.next.next;
        left.next=dum;

        return dummy.next;
    }
}
