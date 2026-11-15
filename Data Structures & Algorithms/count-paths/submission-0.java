class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        
        for(int r=0;r<n;r++){
            row[r]=1;
        }

        for(int r=0;r<m-1;r++){
            int[] newrow= new int[n];
            Arrays.fill(newrow,1);

            for(int j=n-2;j>=0;j--){
                newrow[j]=newrow[j+1]+row[j];
            }
            row=newrow;
        }

        return row[0];
    }
}
