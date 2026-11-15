class Solution {
    Map<String,Integer> dp;
    int t;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        t=target;

        return backtracking(0,0,nums);
    }

    public int backtracking(int i, int total,int[] nums){
        if(i==nums.length){
            if(t==total) return 1;
            else return 0;
        }

        if(dp.containsKey(i+","+total)) return dp.get(i+","+total);

        dp.put(i+","+total,
        (backtracking(i+1,nums[i]+total,nums)
        +backtracking(i+1,total-nums[i],nums)));

        return dp.get(i+","+total);
    }
}
