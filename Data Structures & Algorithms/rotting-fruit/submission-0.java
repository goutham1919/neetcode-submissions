class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols = grid[0].length;
        int time=0;
        int fresh=0;
        Queue<int[]> q = new LinkedList<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    fresh++;
                }if(grid[r][c]==2){
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty() && fresh>0){
            int l=q.size();

            for(int i=0;i<l;i++){
                int[] ar=q.poll();
                int r = ar[0];
                int c=ar[1];

                for(int[] dr : directions){
                    int row=r+dr[0];
                    int col=c+dr[1];

                    if(row<0 || row>=rows || col<0 || col>=cols || 
                    grid[row][col]!=1){
                        continue;
                    }
                    q.offer(new int[]{row,col});
                    grid[row][col]=2;
                    fresh--;
                }
            }
            time++;
        }

        return (fresh==0)?time:-1;
    }
}
