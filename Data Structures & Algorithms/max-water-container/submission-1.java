class Solution {
    public int maxArea(int[] nums) {
        int l=0;
        int r= nums.length-1;
        int w=nums.length-1-0;
        int h=Math.min(nums[0],nums[nums.length-1]);
        int maxarea=w*h;
        while(l<r){
            int wi=r-l;
            int hi=Math.min(nums[l],nums[r]);
            int area=wi*hi;
            if(area>maxarea){
                maxarea=area;
            }
            if(nums[r]>nums[l]){
                l++;
            }
            else{
                r--;
            }


        }
        return maxarea;
    }
}
