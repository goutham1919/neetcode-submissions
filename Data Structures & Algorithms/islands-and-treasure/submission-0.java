class Solution {
    int rows;
    int cols;
    Set<String> visit;
    Queue<int[]> q;
    public void islandsAndTreasure(int[][] grid) {
        visit = new HashSet<>();
        q = new LinkedList<>();

        rows=grid.length;
        cols = grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    q.offer(new int[]{r,c});
                    visit.add(r+","+c);
                }
            }
        }
        int dist=0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i =0;i<l;i++){
                int[] ar = q.poll();

                int r=ar[0];
                int c= ar[1];
                grid[r][c]=dist;
                addroom(r+1,c,grid);
                addroom(r-1,c,grid);
                addroom(r,c+1,grid);
                addroom(r,c-1,grid);
            }
            dist++;
        }
    }

    public void addroom(int r, int c, int[][] arr){
        if(r<0 || r >=rows || c<0 || c>=cols || 
        visit.contains(r+","+c) || arr[r][c]==-1) return;
        
        visit.add(r+","+c);
        q.offer(new int[]{r,c});
    }
}
