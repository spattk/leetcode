class Solution {
    
    Set<Integer> visited = new HashSet<>();
    List<Integer> currentState = new ArrayList<>();
    
    List<List<Integer>> result = new ArrayList<>();
    
    public void solve(int[] nums, int ele) {
        if(currentState.size() == nums.length - 1){
            //base condition
            currentState.add(ele);
            result.add(new ArrayList<>(currentState));
            currentState.remove(currentState.size() - 1);
            return;
        }
        
        visited.add(ele);
        currentState.add(ele);
        for(int idx = 0; idx< nums.length; idx++){
            if(!visited.contains(nums[idx])){
                solve(nums, nums[idx]);
            }
        }
        currentState.remove(currentState.size() - 1);
        visited.remove(ele);
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        for(int idx =0; idx< nums.length; idx++){
            solve(nums, nums[idx]);
        }
        
        return result;
    }
}