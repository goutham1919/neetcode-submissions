class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] count = new List[nums.length+1];
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] re = new int[k];

        for(int i :map.keySet()){
            int freq = map.get(i);
            if(count[freq]==null){
                count[freq]=new ArrayList<>();
            }
            count[freq].add(i);
        }
        int idx=0;
        for(int i=count.length-1;i>=0 && idx<k;i--){
            if(count[i]!=null){
                for(int j : count[i]){
                    re[idx++]=j;
                }
            }
        }
        return re;
    }
}
