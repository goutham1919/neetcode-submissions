class TimeMap {
    Map<String,List<List<String>>> store;
    public TimeMap() {
        store=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key,new ArrayList<>());
        List<String> entry = new ArrayList<>();
        entry.add(value);
        entry.add(String.valueOf(timestamp));

        store.get(key).add(entry);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            return "";
        }

        List<List<String>> ls = store.get(key);
        String res = "";

        int l=0;
        int r= ls.size()-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(Integer.parseInt(ls.get(mid).get(1))<=timestamp){
                res=ls.get(mid).get(0);
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}
