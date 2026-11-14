class Solution {

    Set<String> set;
    int rows;
    int cols;
    char[][] arr;
    public int numIslands(char[][] grid) {
        set=new HashSet<>();
        rows=grid.length;
        cols=grid[0].length;
        arr=grid;
        int island=0;
        for(int r=0;r<rows;r++){
            for(int c =0;c<cols;c++){
                String key = r+","+c;
                if(grid[r][c]=='1' && !set.contains(key)){
                    bfs(r,c);
                    island+=1;
                }
            }
        }
        return island;
    }

    public void bfs(int r , int c){
        Queue<int[]> queue = new LinkedList<>();
        set.add(r+","+c);
        queue.offer(new int[]{r,c});

        while(!queue.isEmpty()){

            int[] dum = queue.poll();
            int row = dum[0];
            int col = dum[1];

            int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

            for(int[] ar: directions){
                r=row+ar[0];
                c=col+ar[1];
                
                if((r>=0 && r<rows) && (c>=0 && c<cols) && 
                !set.contains(r+","+c) && (arr[r][c]=='1')){
                    queue.offer(new int[]{r,c});
                    set.add(r+","+c);
                }
            }
        }
    }
}
