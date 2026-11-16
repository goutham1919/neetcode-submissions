class Solution {
    Map<String,Integer> dp;
    int[] arr;
    public int maxCoins(int[] nums) {
        dp = new HashMap<>();
        arr= new int[nums.length+2];

        for(int i=0;i<nums.length;i++){
            arr[i+1]=nums[i];
        }

        arr[0]=1;
        arr[nums.length+1]=1;

        return dfs(1,nums.length);
    }

    public int dfs(int l, int r){

        if(l>r) return 0;

        String key = l+","+r;
        if(dp.containsKey(key)) return dp.get(key);

        int dum=0;

        for(int i=l;i<r+1;i++){
            int coins = arr[l-1]*arr[i]*arr[r+1];
            coins+=dfs(l,i-1)+dfs(i+1,r);
            dum=Math.max(dum,coins);
        }
        dp.put(key,dum);

        return dp.get(key);
    }
}
