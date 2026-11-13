class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==0) return 0;
        int[] re1 = new int[nums.length-1];
        int[] re2 = new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++){
            re1[i]=nums[i];
        }
        for(int i=1;i<nums.length;i++){
            re2[i-1]=nums[i];
        }

        return Math.max(robb(re1),robb(re2));
    }

    public int robb(int[] nums){
        int rob1=0;
        int rob2=0;

        for(int i : nums){
            int temp = Math.max(rob1+i,rob2);
            rob1=rob2;
            rob2=temp;
        }

        return rob2;
    }
}
