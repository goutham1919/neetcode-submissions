class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];

        for(int i = 0; i < position.length; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr,(x,y)->x[0]-y[0]);
        

        Stack<Float> stack = new Stack<>();
        float fleettime=0;
        for(int i= arr.length-1;i>=0;i--){
            Float prev=0f;
            if(!stack.isEmpty()){
                prev = stack.peek();
            }
            stack.push( (float)(target-arr[i][0])/arr[i][1]);
            if(stack.size()>=2 &&  stack.peek()<=prev){
                stack.pop();
            }
        }
        return stack.size();
    }
}