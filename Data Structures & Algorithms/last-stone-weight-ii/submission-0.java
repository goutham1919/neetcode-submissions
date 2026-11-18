class Solution {
    Map<String,Integer> dp;
    int sum;
    int target;
    public int lastStoneWeightII(int[] stones) {
        dp= new HashMap<>();
        sum=0;
        for(int i: stones){
            sum+=i;
        }

        target=Math.ceilDiv(sum,2);
        return dfs(0,0,stones);

    }

    public int dfs(int i,int total,int[] stones){
        if(i==stones.length || total>=target){
            return Math.abs(total-(sum-total));
        }
        String key = i+","+total;
        if(dp.containsKey(key)) return dp.get(key);

        dp.put(key,
        Math.min(dfs(i+1,total,stones),dfs(i+1,total+stones[i],stones)));

        return dp.get(key);
    }
}