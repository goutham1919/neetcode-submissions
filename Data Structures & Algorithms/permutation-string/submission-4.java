class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] count = new int[26];
        int[] incount=new int[26];
        int ryt= s1.length();
        int matches=0;

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            incount[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(count[i]==incount[i]){
                matches++;
            }
            if(matches==26) return true;
        }

        for(int l=1;l<=s2.length()-s1.length();l++){
            char chl = s2.charAt(l-1);
            //delete left char
            if(count[chl-'a']==incount[chl-'a']) matches--;
            incount[chl-'a']--;
            //update left char matches in both [0-0] freq matching
            if(count[chl-'a']==incount[chl-'a']) matches++;

            char chr=s2.charAt(ryt);
            //check before adding if new char count is equal match changes
            if(count[chr-'a']==incount[chr-'a']) matches--;

            incount[chr-'a']++;
            //update maches
            if(count[chr-'a']==incount[chr-'a']) matches++;

            if(matches==26) return true;
            ryt++;
        }
        return false;
    }
}
