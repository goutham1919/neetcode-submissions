class Solution {
    public boolean isPalindrome(String s) {
        int idx=s.length()-1;
        int i=0;
        while(i<idx){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(idx))){
                idx--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(idx))){
                return false;
            }
            i++;
            idx--;
        }
        return true;
    
    }
}
