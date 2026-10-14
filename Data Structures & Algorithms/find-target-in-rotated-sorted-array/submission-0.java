class Solution {
    public int search(int[] arr, int t) {
        int l=0,r=arr.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==t){
                return mid;
            }
            if(arr[l]<=arr[mid]){
                if(t>arr[mid] || t<arr[l]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                if(t<arr[mid] || t>arr[r]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}