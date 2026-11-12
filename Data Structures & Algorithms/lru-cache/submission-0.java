class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map;
    int cache_cap;
    public LRUCache(int capacity) {
        map=new HashMap(capacity);
        this.cache_cap= capacity;

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node dum=map.get(key);
            remove(dum);
            add(dum);
            return map.get(key).val;
        }
        return -1;
    }

    public void add(Node node){
        //adding after head
        Node dum=head.next;
        head.next= node;
        node.prev=head;
        node.next=dum;
        dum.prev=node;
    }

    public void remove(Node node){
        //removing
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public void put(int key, int value) {
        
       if(!map.containsKey(key)){
        if(map.size()>=cache_cap){
            Node rr= tail.prev;
            remove(tail.prev);
            map.remove(rr.key);
       }
        Node node =new Node(key,value);
        map.put(key,node);
        add(node);
       }
        else{
            Node node = map.get(key);
            remove(node);
            node.val=value;
            add(node);
        }
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
