class Solution {
    public int search(int[] nums, int t) {
        int l=0;
        int r= nums.length-1;

        while(l<=r){
            int mid= l + (r-l)/2;

            if(nums[mid]== t) return mid;

            if(nums[mid]>=nums[l]){
                if(t>=nums[mid] || t<nums[l]) l=mid+1;
                else r=mid-1;
            }
            else{
                if(t<=nums[mid] || t>nums[r]) r=mid-1;
                else l=mid+1;
            }
        }

        return -1;
    }
}
