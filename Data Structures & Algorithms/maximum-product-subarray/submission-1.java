class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;

        for(int i : nums){
            res=Math.max(res,i);
        }
        int currMax=1;
        int currMin=1;

        for(int i : nums){
            if(i==0){
                currMax=1;
                currMin=1;
                continue;
            }
            int temp = currMax*i;
            currMax=Math.max(i*currMax,Math.max(i*currMin,i));
            currMin=Math.min(temp,Math.min(i*currMin,i));
            res=Math.max(res,currMax);
        }

        return res;
    }
}
