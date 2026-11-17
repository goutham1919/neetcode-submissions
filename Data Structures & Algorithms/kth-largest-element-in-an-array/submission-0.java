class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();

        for(int i : nums){
            ls.add(i);
        }

        int re=ls.stream().sorted((a,b)->b-a).skip(k-1).findFirst().orElse(-1);

        return re;
    }
}
