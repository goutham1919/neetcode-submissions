class Solution {
    Map<Integer,List<Integer>> map;
    Set<Integer> visit;
    Set<Integer> cycle;
    List<Integer> ls;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visit= new HashSet<>();
        cycle = new HashSet<>();
        ls=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] ar : prerequisites){
            map.get(ar[0]).add(ar[1]);
        }
        for(int cr=0;cr<numCourses;cr++){
            if(!dfs(cr)) return new int[]{};
        }
        
        int[] result = new int[ls.size()];
        int idx=0;
        for(int i : ls){
            result[idx++]=i;
        }

        return result;
    }

    public boolean dfs(int crs){
        if(cycle.contains(crs)) return false;
        if(visit.contains(crs)) return true;
        cycle.add(crs);
        for(int pre : map.get(crs)){
            if(!dfs(pre)) return false;
        }

        cycle.remove(crs);
        visit.add(crs);
        ls.add(crs);

        return true;
    }
}
