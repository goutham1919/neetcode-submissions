class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r=0;
        for(int i : piles){
            if(i>r){
                r=i;
            }
        }

        int l=1;
        int res=r;

        while(l<=r){
            int k=l+(r-l)/2;
            long hours=0;
            for(int i:piles){
                hours+=(i+k-1)/k;
            }

            if(hours<=h){
                res=Math.min(res,k);
                r=k-1;
            }else{
                l=k+1;
            }
        }
        return res;
    }
}