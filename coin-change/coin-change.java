class Solution {
    HashMap<String, Integer> map;
    public int solve(int[] coins, int amount, int n){
        if (amount == 0){
            return 0;
        } else if (amount < 0 || n <= 0) {
            return Integer.MAX_VALUE - 5;
        } 
        
        String key = "" + amount + "*" + n;
        if (map.get(key)!=null){
            return map.get(key);
        }
        int temp = Math.min(
                1 + solve(coins, amount - coins[n-1], n),
                solve(coins, amount, n-1)
            );
        
        map.put(key, temp);
        return temp;
        
    }
    
    public int coinChange(int[] coins, int amount) {
        map = new HashMap<>();
        int temp= solve(coins, amount, coins.length);
        if (temp >= Integer.MAX_VALUE - 5 ){
            return -1;
        } else{
            return temp;
        }
    }
}