class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] re = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int r=stack.pop();
                re[r]=i-r;
            }
            stack.push(i);
        }
        return re;
    }
}