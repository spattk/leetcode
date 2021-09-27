class Solution {
    
    HashMap<String, Integer> map;
    public int helper(int m, int n){
        if(m == 1 || n == 1){
            return 1;
        }
        
        if (m <= 0 || n <= 0)
            return 0;
        
        String key = "" + m + "*" + n;
        if (map.get(key) != null){
            return map.get(key);
        }
        int temp =  helper(m-1, n) + helper(m, n-1);
        map.put(key,temp);
        return temp;
    }
    
    public int uniquePaths(int m, int n) {
        map = new HashMap<>();
        return helper(m, n);
    }
}