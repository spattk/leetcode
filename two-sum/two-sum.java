class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.get(target-nums[i]) != null){
                return new int[]{map.get(target-nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
            
        }
        return new int[]{-1, -1};
    }
}