class Solution {
    public int[] productExceptSelf(int[] arr) {
        int[] re = new int[arr.length];
        int pre =1;
        re[0]=pre;
        for(int i=0;i<arr.length-1;i++){
            pre*=arr[i];
            re[i+1]=pre;
        }
        int pf=1;
        for(int i=arr.length-1;i>=0;i--){
            re[i]*=pf;
            pf*=arr[i];
        }
        return re;
    }
}  
