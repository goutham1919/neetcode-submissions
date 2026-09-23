class Solution {

    public String encode(List<String> strs) {
        String st="";
        for(String s : strs){
            int l = s.length();
            st+=String.valueOf(l)+"#"+s;
        }
        return st;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int l = Integer.parseInt(str.substring(i,j));
            list.add(str.substring(j+1,l+j+1));
            i=j+l+1;
        }
        return list;
    }
}
