class Solution {
    public boolean searchMatrix(int[][] nums,int target) {
        int top=0;
        int bot=nums.length-1;

        while(top<=bot){
            int row=top+(bot-top)/2;
            if(nums[row][0]>target){
                bot=row-1;
            }else if(nums[row][nums[row].length-1]<target){
                top=row+1;
            }else{
                break;
            }
        }
        if(!(top<=bot)) return false;
        int row=top+(bot-top)/2;
        int l=0;
        int r= nums[0].length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[row][mid]==target) return true;
            else if (nums[row][mid]>target) r=mid-1;
            else l=mid+1;
        }
        return false;
    }
}