class Solution {
    Map<String,Integer> dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp= new HashMap<>();
        int path=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                path=Math.max(path,dfs(i,j,-1,matrix));
            }
        }
        return path;
    }

    public int dfs(int r, int c , int prev, int[][] matrix){
        if(r<0 || r>=matrix.length || 
           c<0 || c>=matrix[0].length ||
           prev>=matrix[r][c]){
            return 0;
           }
        String key = r+","+c;
        if(dp.containsKey(key)) return dp.get(key);

        int res=1;

        res=Math.max(res,1+dfs(r+1,c,matrix[r][c],matrix));
        res=Math.max(res,1+dfs(r-1,c,matrix[r][c],matrix));
        res=Math.max(res,1+dfs(r,c+1,matrix[r][c],matrix));
        res=Math.max(res,1+dfs(r,c-1,matrix[r][c],matrix));

        dp.put(key,res);
        return res;
    }
}
