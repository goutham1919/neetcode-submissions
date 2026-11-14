class Solution {
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        int result=0;
        rows=grid.length;
        cols=grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                result=Math.max(result,dfs(r,c,grid));
            }
        }

        return result;

    }

    public int dfs(int r,int c,int[][]grid){
        if(r<0 || r >=rows || c<0 || c>=cols || grid[r][c]!=1){
            return 0;
        }
        grid[r][c]=0;
        
        return 1+dfs(r,c-1,grid)
        +dfs(r,c+1,grid)
        +dfs(r+1,c,grid)
        +dfs(r-1,c,grid);
    }
}
