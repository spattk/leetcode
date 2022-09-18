class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        int def = -1 * (n + 1);
        boolean isZero = false;
        //loop 1 - filter out the negative numbers
        for(int i=0; i<n; i++) {
            
            if(nums[i] == 0)
                isZero = true;
            
            if(nums[i] < 0)
                nums[i] = 0;
            
            
        }
        
        //loop 2
        for(int i=0; i<n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(idx >= 0 && idx < n) {
                if(nums[idx] == 0) {
                    nums[idx] = def;
                } else {
                    nums[idx] = -1 * Math.abs(nums[idx]);
                }
            }
        }
        
        // System.out.println(Arrays.toString(nums));
        
        //loop 3
        for(int i=1; i<=n; i++){
            if(nums[i-1] >= 0)
                return i;
        }
        
        return n+1;
    }
}