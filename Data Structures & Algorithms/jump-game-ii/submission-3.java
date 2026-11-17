class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp= new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);

        return dfs(0,nums);
    }

    public int dfs(int i,int[] nums){
        if(i>=nums.length-1) return 0;
        if(dp[i]!=Integer.MAX_VALUE) return dp[i];

        for(int j=1;j<=nums[i];j++){
            if(i+j<nums.length){
                int result=dfs(i+j,nums);
                if(result!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+result);
                }
            }
            
        }

        return dp[i];
    }
}
