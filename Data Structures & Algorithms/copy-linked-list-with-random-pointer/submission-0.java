/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node,Node> map = new HashMap<>();
        Node curr=head;

        while(curr!=null){
            Node copy = new Node(curr.val);
            map.put(curr,copy);
            curr=curr.next;
        }

        Node cur = head;
        while(cur!=null){
            Node copy = map.get(cur);
            copy.next=map.get(cur.next);
            copy.random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}
