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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode Shalf = slow.next;
        ListNode prev =null;
        slow.next=null;

        while(Shalf!=null){
            ListNode temp = Shalf.next;
            Shalf.next=prev;
            prev=Shalf;
            Shalf=temp;
        }

        ListNode second = prev;
        ListNode first = head;

        while(second!=null){

            ListNode temp1=first.next;
            ListNode temp2 = second.next;
            first.next =second;
            second.next=temp1;

            first=temp1;
            second=temp2; 
        }
    }
}
