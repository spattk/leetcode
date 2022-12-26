class Solution {
    
    HashMap<Integer, Boolean> map;
    public boolean helper(int[] nums, int t){
        if (t >= nums.length - 1){
            return true;
        }
        
        if (nums[t] == 0)
            return false;
        
        if (t + nums[t] >= nums.length - 1){
            return true;
        }
        
        if(map.get(t) != null){
            return map.get(t);
        }
        
        boolean result = false;
        for(int i=t+1;i<=t+nums[t];i++){
            result |= helper(nums, i);
        }
        map.put(t, result);
        return result;
    }
    
    public boolean canJump(int[] nums) {
        map = new HashMap<>();
        return helper(nums, 0);
    }
}