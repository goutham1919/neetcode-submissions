class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea=0;

        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] arr = stack.pop();
                maxArea=Math.max(maxArea,arr[1]*(i-arr[0]));
                start=arr[0];
            }
            stack.push(new int[]{start,heights[i]});
        }

        for(int[] arr : stack){
            maxArea=Math.max(maxArea,arr[1]*(heights.length-arr[0]));
        }
        return maxArea;
    }
}
