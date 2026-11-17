class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i : hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(map.keySet());

        while(!heap.isEmpty()){
            int first = heap.peek();

            for(int i=first;i<first+groupSize;i++){
                if(!map.containsKey(i)) return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0){
                    if(heap.peek()!=i){
                        return false;
                    }
                    heap.poll();
                }
            }
        }

        return true;

    }
}
