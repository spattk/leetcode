class Solution {
    
    Map<String, Integer> map;
    public int solve(int[] nums, int target, int n){
        if (n == 0 && target == 0){
            return 1;
        }
        
        if (n==0)
            return 0;
        
        
        String key = "" + target + "," + (n-1);
        if (map.get(key)!=null)
            return map.get(key);
        
        map.put(key,solve(nums, target+nums[n-1], n-1) + solve(nums, target-nums[n-1], n-1));
        return map.get(key);
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        map = new HashMap<>();
        return solve(nums, target, n);
    }
}