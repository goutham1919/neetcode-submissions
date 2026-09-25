class Solution {
    public String minWindow(String s, String t) {
        if(t.equals("")) return "";
        Map<Character,Integer> count = new HashMap<>();
        Map<Character,Integer> win = new HashMap<>();

        for(char ch : t.toCharArray()){
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        int re[] ={-1,-1};
        int rel=Integer.MAX_VALUE;
        int have=0,need=count.size();
        int l=0;

        for(int r=0;r<s.length();r++){
            char ch =s.charAt(r);
            win.put(ch,win.getOrDefault(ch,0)+1);
            if(count.containsKey(ch) && win.get(ch).equals(count.get(ch))){
                have++;
            }

            while(have==need){
                if(r-l+1<rel){
                    re[0]=l;
                    re[1]=r;
                    rel=r-l+1;
                }
                win.put(s.charAt(l),win.get(s.charAt(l))-1);
                if(count.containsKey(s.charAt(l)) && win.get(s.charAt(l))<count.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
        }
        return re[0]==-1?"":s.substring(re[0],re[1]+1);
    }
}