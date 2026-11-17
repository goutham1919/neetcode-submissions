class Solution {
    public int jump(int[] nums) {
        int result=0;
        int l=0,r=0;

        while(r<nums.length-1){
            int far=0;
            for(int i=0;i<r+1;i++){
                far=Math.max(far,i+nums[i]);
            }
            l=r+1;
            r=far;
            result+=1;
        }

        return result;
    }
}
