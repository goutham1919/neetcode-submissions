class Solution {
    Map<String,Integer> dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new HashMap<>();
        return dfs(0,m,n,strs);
    }

    public int dfs(int i,int m, int n, String[] strs){
        if(i==strs.length) return 0;
        String key = i+","+m+","+n;

        if(dp.containsKey(key)) return dp.get(key);

        dp.put(key,dfs(i+1,m,n,strs));

        int mct=count(strs[i],'0');
        int nct=count(strs[i],'1');

        if(mct<=m && nct<=n){
            dp.put(key,Math.max(dp.get(key),1+dfs(i+1,m-mct,n-nct,strs)));
        }

        return dp.get(key);
    }

    public int count(String s, char ch){
        int count=0;
        for(char c : s.toCharArray()){
            if(c==ch) count++;
        }

        return count;
    }
}