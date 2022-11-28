class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int closest = -1;
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            int l = i + 1;
            int r = n - 1;
            
            while(l < r){
                int threeSum = nums[i] + nums[l] + nums[r];
                
                if(Math.abs(threeSum - target) < min){
                    min = Math.abs(threeSum - target);
                    closest = threeSum;
                    
                    if(min == 0)
                        return closest;
                }
                
                if(threeSum < target){
                    l++;
                }
                else if (threeSum > target){
                    r--;
                }
            }
        }
        
        return closest;
    }
}