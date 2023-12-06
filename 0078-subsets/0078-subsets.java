class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentState = new ArrayList<>();
    
    public void solve(int[] nums, int idx) {
        
        if(idx == nums.length){
            result.add(new ArrayList<>(currentState));
            return;
        }
        
        //add
        currentState.add(nums[idx]);
        solve(nums, idx+1);
        currentState.remove(currentState.size() - 1);
        
        //don't add
        solve(nums, idx+1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0);
        return result;
    }
}