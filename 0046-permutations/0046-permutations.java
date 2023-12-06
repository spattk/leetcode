class Solution {
    
    List<Integer> currentState = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    
    public void solve(int[] nums) {
        
        if(currentState.size() == nums.length){
            result.add(new ArrayList<>(currentState));
            return;
        }
        
        for(int idx = 0; idx< nums.length; idx++){
            
            if(!visited.contains(nums[idx])) {
                visited.add(nums[idx]);
                currentState.add(nums[idx]);
                solve(nums);
                currentState.remove(currentState.size() - 1);
                visited.remove(nums[idx]);
            }
            
            
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        solve(nums);
        
        return result;
    }
}