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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode();
        ListNode dum = node;
        ListNode he=head;

        while(he!=null){
            int x=0;
            ListNode dummy1 = new ListNode();
            ListNode dummy=dummy1;
            for(int i=0;i<k && he!=null;i++){
                dummy.next=he;
                he=he.next;
                dummy=dummy.next;
                x=x+1;
            }
            dummy.next=null;
            if(x<k){
                dum.next=dummy1.next;
                dum=dummy1.next;
            }else{
                dum.next=rev(dummy1.next);
                dum=rev(dummy1.next);
            }

        }
        return node.next;
    }

    public ListNode rev(ListNode node){
        ListNode curr=node;
        ListNode prev=null;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}
