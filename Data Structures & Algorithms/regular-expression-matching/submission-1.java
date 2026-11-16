class Solution {
    Map<String,Boolean> dp;
    public boolean isMatch(String s, String p) {
        dp= new HashMap<>();
        return dfs(0,0,s,p);
    }

    public boolean dfs(int i, int j,String s, String p){
        String key = i+","+j;
        if(dp.containsKey(key)) return dp.get(key);
        if(i>=s.length() && j>=p.length()) return true;

        if(j>=p.length()) return false;

        boolean match=false;
        if(i<s.length()){
            match=(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        }

        if(j+1<p.length() && p.charAt(j+1)=='*'){
            dp.put(key ,dfs(i,j+2,s,p) || // dont use
                (match && dfs(i+1,j,s,p))); //use

            return dp.get(key);
        }
        if(match){
            dp.put(key, dfs(i+1,j+1,s,p));
            return dp.get(key);
        }
        dp.put(key,false);
        return dp.get(key);
    }

}
