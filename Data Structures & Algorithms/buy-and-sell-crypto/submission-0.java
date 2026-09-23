class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int MaxProfit=0;
        while(r<prices.length){
            if(prices[l]>prices[r]){
                l=r;
                r++;
            }
            else{
                int pr = prices[r]-prices[l];
                MaxProfit=Math.max(pr,MaxProfit);
                r++;
            }
        }
        return MaxProfit;
    }
}
