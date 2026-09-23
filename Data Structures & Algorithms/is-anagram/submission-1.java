class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length()!=t.length()) return false;

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)) return false;
            map.put(ch,map.getOrDefault(ch,1)-1);
        }
        for(int i : map.values()){
            if(i>0) return false;
        }
        return true;
    }
}
