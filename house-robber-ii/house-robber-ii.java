class Solution {
    
    HashMap<String, Integer> map;
    public int solve(int[] nums, int n, boolean last){
        if(n<0){
            return 0;
        }
        
        else if (n == 0){
            if (last){
                return 0;
            } else {
                return nums[0];
            }
        }
        
        String key = "" + n + "*" + last;
        if(map.get(key) != null){
            return map.get(key);
        }
        
        int temp;
        if(n == nums.length-1 ){
            temp = Math.max(solve(nums, n-2, true) + nums[n], solve(nums, n-1, false));
        } else{
            temp = Math.max(solve(nums, n-2, last) + nums[n], solve(nums, n-1, last));
        }
        
        map.put(key, temp);
        return temp;
        
        
    }
    
    public int rob(int[] nums) {
        map = new HashMap<>();
        return solve(nums, nums.length-1, false);
    }
}