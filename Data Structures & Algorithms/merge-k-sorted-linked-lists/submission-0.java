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
        if(lists.length<1) return null;
        List<Integer> ls = new ArrayList<>();

        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];

            while(temp!=null){
                ls.add(temp.val);
                temp=temp.next;
            }
        }

        ls.sort((a,b)->a-b);

        ListNode node = new ListNode(0);
        ListNode head = node;

        for(int i : ls){
            ListNode dum = new ListNode(i);
            head.next=dum;
            head=head.next;
        }

        return node.next;
    }
}
