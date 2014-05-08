public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int total = 0;
        int current = 0;
        int startP = 0;
        if(gas.length<=0)
            return -1;
            
        for(i = 0; i < gas.length;i++){
            current += gas[i]-cost[i];
            total += gas[i]-cost[i];
            if(current < 0){
                current = 0;
                startP = i+1;
            }
        }
        if(total<0)
            return -1;
        else
            return startP;
    }
}
