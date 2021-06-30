class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int fc = 0;
        int ml = 0;
        int n = nums.length;
        
        while(end<n){
            if (nums[end] == 1){
                end++;
            } else if (nums[end] == 0 && fc < k) {
                end++;
                fc++;
            } else if (nums[end]==0 && fc>=k) {
                while(fc>=k && start<=end){
                    if (nums[start]==0){
                        start ++;
                        fc--;
                    } else {
                        start++;
                    }
                }
            }
            
            ml = Math.max(ml, end-start);
        }
        
        return ml;
    }
}