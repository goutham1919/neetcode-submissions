class Solution {
    Map<String,Integer> dp;
    public int numDistinct(String s, String t) {
        dp= new HashMap<>();

        return dfs(0,0,s,t);
    }

    public int dfs(int i, int j, String s, String t){
        if(j==t.length()) return 1;

        if(i==s.length()) return 0;

        String key = i+","+j;
        if(dp.containsKey(key)) return dp.get(key);

        if(s.charAt(i)==t.charAt(j)){
            dp.put(key,dfs(i+1,j+1,s,t)+dfs(i+1,j,s,t));
        }else{
            dp.put(key,dfs(i+1,j,s,t));
        }

        return dp.get(key);
    }
}
