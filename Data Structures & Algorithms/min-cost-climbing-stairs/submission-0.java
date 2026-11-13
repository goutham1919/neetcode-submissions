class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] re = new int[cost.length+1];

        for(int i=0;i<cost.length;i++){
            re[i]=cost[i];
        }

        for(int i=re.length-3;i>=0;i--){
            re[i]=Math.min(re[i]+re[i+1],re[i]+re[i+2]);
        }

        return Math.min(re[0],re[1]);
    }
}
