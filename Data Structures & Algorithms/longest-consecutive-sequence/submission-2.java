class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int l=1;
        int x=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            if(nums[i]+1==nums[i+1]){
                x++;
            }
            
            else{
                l=Math.max(l,x);
                x=1;
            }


        }
        return Math.max(l,x);
    }
}
