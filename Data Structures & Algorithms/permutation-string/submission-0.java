class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int[] incount = new int[26];
        int ryt = s1.length();
        int match=0;
        if(s1.length()>s2.length()) return false;

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            incount[s2.charAt(i)-'a']++;
        }
        if(match==26) return true;
        for (int i = 0; i <26 ; i++) {
            if(count[i]==incount[i]) match++;
            if(match==26) return true;

        }

        

        for(int l=1;l<=s2.length()-s1.length();l++){
            if(incount[s2.charAt(l-1)-'a']==count[s2.charAt(l-1)-'a']){
                match--;
            }
            incount[s2.charAt(l-1)-'a']--;

            if(incount[s2.charAt(l-1)-'a']== count[s2.charAt(l-1)-'a']){
                match++;
            }

            if(incount[s2.charAt(ryt)-'a']==count[s2.charAt(ryt)-'a']){
                match--;
            }
            incount[s2.charAt(ryt)-'a']++;
            if(incount[s2.charAt(ryt)-'a']==count[s2.charAt(ryt)-'a']){
                match++;
            }
            if(match==26){
                return true;
            }
            ryt++;

        }
        return false;
    }    
    
}