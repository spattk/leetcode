class Solution {
    
    public int sum(int[] ar){
        int total = 0;
        for(int ele: ar){
            total += ele;
        }
        
        return total;
    }
    
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(sum(gas) < sum(cost))
            return -1;
        
        int start = 0;
        int total = 0;
        for(int i=0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            total += diff;
            if(total< 0){
                total = 0;
                start = i + 1;
            }
        }
        
        return start;
    }
}