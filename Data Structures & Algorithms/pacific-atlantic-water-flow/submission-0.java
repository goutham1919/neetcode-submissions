class Solution {
    int rows;
    int cols;
    Set<String> pac;
    Set<String> alt;
     int[][] arr;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows=heights.length;
        cols=heights[0].length;
        pac= new HashSet<>();
        alt= new HashSet<>();
        arr=heights;

        for(int c=0;c<cols;c++){
            dfs(0,c,pac,heights[0][c]);
            dfs(rows-1,c,alt,heights[rows-1][c]);
        }

        for(int r=0;r<rows;r++){
            dfs(r,0,pac,heights[r][0]);
            dfs(r,cols-1,alt,heights[r][cols-1]);
        }

        List<List<Integer>> re = new ArrayList<>();

        for(int r =0;r<rows;r++){
            for(int c =0; c<cols;c++){
                if(pac.contains(r+","+c) && alt.contains(r+","+c)){
                re.add(Arrays.asList(r,c));
                }
            }
        }

        return re;
    }

    public void dfs(int r , int c ,Set<String> visit, int prevht){

        if(r<0 || r>=rows || c<0 || c>=cols || 
        arr[r][c]<prevht || visit.contains(r+","+c)) return;

        visit.add(r+","+c);

        dfs(r+1,c,visit,arr[r][c]);
        dfs(r-1,c,visit,arr[r][c]);
        dfs(r,c+1,visit,arr[r][c]);
        dfs(r,c-1,visit,arr[r][c]);
    }
}
