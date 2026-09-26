class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String s : tokens){
            char ch =s.charAt(0);
            if(!Character.isDigit(ch) && s.length()==1){
                    int val2=stack.pop();
                    int val1=stack.pop();
                    int re=0;
                    if(ch=='+'){
                        re=val1+val2;
                    }else if(ch=='-'){
                        re=val1-val2;
                    }else if(ch=='*'){
                        re=val1*val2;
                    }else{
                        re=val1/val2;
                    }
                    stack.push(re);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}