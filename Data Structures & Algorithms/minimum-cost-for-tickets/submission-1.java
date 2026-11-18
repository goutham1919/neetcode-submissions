class Solution {
    Integer[] dp;
    
    public int mincostTickets(int[] days, int[] costs) {
        dp=new Integer[days.length];
        return dfs(0,costs,days);
    }

    public int dfs(int i,int[] costs, int[] days){
        if(i==days.length) return 0;

        if(dp[i]!=null) return dp[i];

        dp[i]=Integer.MAX_VALUE;
        int[] durations = {1,7,30};
        for(int k=0;k<durations.length;k++){
            int c=costs[k];
            int d=durations[k];
            int j=i;
            while(j<days.length && days[j]<days[i]+d){
                j++;
            }

            dp[i]=Math.min(dp[i],c+dfs(j,costs,days));

        }

        return dp[i];
    }
}