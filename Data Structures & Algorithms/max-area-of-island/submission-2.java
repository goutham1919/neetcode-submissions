class Solution {
    int rows;
    int cols;
    Set<String> set;
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        set=new HashSet<>();
        rows=grid.length;
        cols=grid[0].length;
        int result=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                 result=Math.max(bfs(r,c,grid),result);
                }
            }
        }

        return result;
    }

    public int bfs(int r, int c , int[][] grid){
        area=1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        set.add(r+","+c);

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int row=arr[0];
            int col = arr[1];

            int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

            for(int[] dr : dir){
                r=row+dr[0];
                c=col+dr[1];

                if((r>=0 && r<rows) && (c>=0 && c<cols) 
                && (grid[r][c]==1) && !set.contains(r+","+c)){
                    q.offer(new int[]{r,c});
                    set.add(r+","+c);
                    area++;
                }
            }
        }
        return area;
    }
}
