class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxcurr = 0;
        
        int n = nums.length;
        for(int i=0;i<n;i++){
            maxcurr += nums[i];
            maxcurr = Math.max(nums[i], maxcurr);
            max = Math.max(max, maxcurr);
        }
        
        return max;
    }
}