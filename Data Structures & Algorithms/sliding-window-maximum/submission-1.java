class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1) return new int[]{nums[0]};
        int[] result=new int[nums.length-k+1];
        Deque<Integer> deq = new ArrayDeque<>();
        int l=0,r=0;
        int idx=0;
        
        while(r<nums.length){
            while(!deq.isEmpty()&&nums[deq.peekLast()]<nums[r]){
                deq.pollLast();
            }
            deq.offerLast(r);

            if(l>deq.peekFirst()){
                deq.pollFirst();
            }

            if(r+1>=k){
                result[idx++]=nums[deq.peekFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}