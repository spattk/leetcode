class Solution {
    HashMap<Integer, Integer> map;
    public int solve(int t, int n){
        if (t >n){
            return 0;
        } else if (t == n){
            return 1;
        }
        if(map.get(t) != null){
            return map.get(t);
        }
        
        map.put(t,solve(t+1, n) + solve(t+2,n));
        return map.get(t);
    }
    
    public int climbStairs(int n) {
        map = new HashMap<>();
        return solve(1, n) + solve(2,n);
    }
}