class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp= new Boolean[nums.length];
        return dfs(0,nums);

    }

    public boolean dfs(int i, int[] nums){
        if(i>=nums.length-1) return true;

        if(dp[i]!=null) return dp[i];

        for(int j=1;j<=nums[i];j++){
            if(dfs(i+j,nums)){
                dp[i]=true;
                return true;
            }
        }

        dp[i]=false;
        return false;
    }
}
