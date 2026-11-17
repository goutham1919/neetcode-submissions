class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumgas=0;
        int sumcost=0;

        for(int i: gas){
            sumgas+=i;
        }

        for(int i : cost){
            sumcost+=i;
        }

        if(sumgas<sumcost) return -1;

        int total =0;
        int re=0;

        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                re=i+1;
            }
        }

        return re;
    }
}
