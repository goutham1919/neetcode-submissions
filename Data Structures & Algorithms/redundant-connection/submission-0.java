class Solution {
    int[] par;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        par=new int[edges.length+1];
        rank = new int[edges.length+1];

        for(int i=0;i<edges.length+1;i++){
            par[i]=i;
            rank[i]=1;
        }

        for(int[] ne : edges){
            int n1=ne[0];
            int n2=ne[1];
            if(!union(n1,n2)){
                return new int[]{n1,n2};
            }
        }

        return new int[]{};

    }

    public int find(int n){
        int p = par[n];

        while(p!=par[p]){
            par[p]=par[par[p]];
            p=par[p];
        }

        return p;
    }

    public boolean union(int n1, int n2){
        int p1=find(n1);
        int p2=find(n2);

        if(p1==p2){
            return false;
        }
        if(rank[p1]>rank[p2]){
            par[p2]=p1;
            rank[p1]+=rank[p2];
        }else{
            par[p1]=p2;
            rank[p2]+=rank[p1];
        }

        return true;
    }
}
