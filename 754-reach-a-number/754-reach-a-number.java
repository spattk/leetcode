class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int pos = 0, step = 1;
        while(pos < target){
            pos += step;
            step++;
        }
        
        while((pos - target)%2 == 1){
            pos += step;
            step++;
        }
        
        return step - 1;
    }
}