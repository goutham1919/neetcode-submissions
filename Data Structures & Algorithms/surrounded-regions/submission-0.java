class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows=board.length;
        cols=board[0].length;
        
        //unsurrounded
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if((board[r][c]=='O') && 
                (r==0 || r== rows-1 || c==0 || c==cols-1)){
                    dfs(r,c,board);
                }
            }
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
            }
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='T'){
                    board[r][c]='O';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] arr){
        if(r<0 || r>=rows || c<0 || c>=cols || arr[r][c]!='O'){
            return;
        }

        arr[r][c]='T';

        dfs(r+1,c,arr);
        dfs(r-1,c,arr);
        dfs(r,c+1,arr);
        dfs(r,c-1,arr);
    }
}
