class Solution {
    public int[] twoSum(int[] nums, int t) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] idx = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(t-nums[i])){
                idx[0]=map.get(t-nums[i]);
                idx[1]=i;
            }
            map.put(nums[i],i);
        }
        return idx;
    }
}