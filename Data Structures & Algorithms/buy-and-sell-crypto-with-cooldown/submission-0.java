class Solution {
    Map<String,Integer> dp;
    public int maxProfit(int[] prices) {
        dp=new HashMap<>();

        return dfs(0,true,prices);
    }

    public int dfs(int i, boolean buy, int[] arr){
        if(i>=arr.length) return 0;

        if(dp.containsKey(i+","+buy)){
            return dp.get(i+","+buy);
        }

        if(buy){
            int by = dfs(i+1,!buy,arr)-arr[i];
            int cooldown= dfs(i+1,buy,arr);
            dp.put(i+","+buy,Math.max(by,cooldown));
        }else{
            int sell = dfs(i+2,!buy,arr)+arr[i];
            int cooldown = dfs(i+1,buy,arr);
            dp.put(i+","+buy,Math.max(sell,cooldown));
        }

        return dp.get(i+","+buy);
    }
}
