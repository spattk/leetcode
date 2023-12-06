class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentState = new ArrayList<>();
    
    public void solve(int[] nums, int idx) {
    
        //base condition
        result.add(new ArrayList<>(currentState));
        
        for(int i=idx; i<nums.length; i++) {
            currentState.add(nums[i]);
            solve(nums, i+1);
            currentState.remove(currentState.size() - 1);
        }
        
        
        
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0);
        return result;
    }
}