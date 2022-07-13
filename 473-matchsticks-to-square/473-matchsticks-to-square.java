class Solution {
    
    public boolean backtrack(int idx, int[] matchsticks, int[] sides, int len){
        if(idx == matchsticks.length)
            return true;
        
        for(int j=0;j<4;j++){
            if(sides[j] + matchsticks[idx] <= len){
                sides[j] += matchsticks[idx];
                if(backtrack(idx + 1, matchsticks, sides, len))
                    return true;
                sides[j] -= matchsticks[idx];
            }
        }
        return false;
    }
    
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num: matchsticks){
            sum += num;
        }
        if(sum % 4 != 0)
            return false;
        
        int len = sum / 4;
        int[] sides = new int[4];
        matchsticks = Arrays.stream(matchsticks).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return backtrack(0, matchsticks, sides, len);
    }
}