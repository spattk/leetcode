class Solution {
    
    HashMap<Integer, Integer> map;
    public int solve(int[] nums, int n){
        if (n < 0){
            return 0;
        }
        if (map.get(n) != null){
            return map.get(n);
        }
        int temp = Math.max(nums[n] + solve(nums, n-2), solve(nums, n-1));
        map.put(n, temp);
        return temp;
    }
    
    public int rob(int[] nums) {
        map = new HashMap<>();
        return solve(nums, nums.length - 1);
    }
}