class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer,HashSet<Character>> sqrs = new HashMap<>();

        for(int i=0;i<9;i++){
            rows.put(i,new HashSet<>());
            cols.put(i,new HashSet<>());
            sqrs.put(i,new HashSet<>());
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.'){
                    continue;
                }
                char dummy = board[r][c];
                int box = (r/3)*3 + (c/3);

                if(rows.get(r).contains(dummy) || cols.get(c).contains(dummy)|| sqrs.get(box).contains(dummy)){
                    return false;
                }
                rows.get(r).add(dummy);
                cols.get(c).add(dummy);
                sqrs.get(box).add(dummy);
            }
            
        }
        return true;
    }
}
