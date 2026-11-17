class Solution {
    public int maxSubArray(int[] nums) {
        int maxsub=nums[0];
        int currsum=0;

        for(int i : nums){
            if(currsum<0){
                currsum=0;
            }

            currsum+=i;
            maxsub=Math.max(maxsub,currsum);
        }

        return maxsub;
    }
}
