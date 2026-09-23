class Solution {
    public int trap(int[] arr) {
        int l=0;
       int r=arr.length-1;
       int maxl=arr[l];
       int maxr=arr[r];
       int sum=0;

       while(l<r){
        if(maxl<=maxr){
            if(maxl-arr[l]>0){
                sum+=maxl-arr[l];
            }
            l++;
            maxl=Math.max(maxl,arr[l]);
            //l++;
        }else{
            if(maxr-arr[r]>0){
                sum+=maxr-arr[r];
            }
            r--;
            maxr=Math.max(maxr,arr[r]);
        }
       }
       return sum;
    }
}
