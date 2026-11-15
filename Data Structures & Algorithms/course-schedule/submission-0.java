class Solution {
    Map<Integer,List<Integer>> map;
    Set<Integer> visit;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map= new HashMap<>();
        visit = new HashSet<>();

        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int cur = arr[0];
            int pre = arr[1];

            map.get(cur).add(pre);
        }

        for(int cr=0;cr<numCourses;cr++){
            if(!dfs(cr)) return false;
        }

        return true;
    }

    public boolean dfs(int crs){

        if(visit.contains(crs)) return false;
        if(map.get(crs)==null) return true;

        visit.add(crs);

        for(int pre : map.get(crs)){
            if(!dfs(pre)) return false;
        }

        visit.remove(crs);
        map.put(crs, new ArrayList<>());
        return true;
    }
}
