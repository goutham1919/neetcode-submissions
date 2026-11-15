class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,0);
        dp[0]=1;

        for(int i=coins.length-1;i>=0;i--){
            int[] newdp = new int[amount+1];
            Arrays.fill(newdp,0);
            newdp[0]=1;

            for(int a=0;a<amount+1;a++){
                newdp[a]=dp[a];
                if(a-coins[i]>=0){
                    newdp[a]+=newdp[a-coins[i]];
                }
            }
            dp=newdp;
        }

        return dp[amount];
    }
}
