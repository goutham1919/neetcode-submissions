class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> dp = new HashSet<>();

        int sum =0;

        for(int i : nums){
            sum+=i;
        }

        if(sum%2==1) return false;

        int target = sum/2;
        dp.add(0);
        for(int i = nums.length-2;i>=0;i--){
            Set<Integer> newDp = new HashSet<>();
            for(int s : dp){
                if(s+nums[i]<=target){
                    newDp.add(s+nums[i]);
                }
                newDp.add(s);
            }
            dp=newDp;
        }

        return dp.contains(target);
    }
}
