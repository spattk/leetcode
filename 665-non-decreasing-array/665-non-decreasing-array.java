class Solution {
    
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0;i< dp.length;i++){
            int pos = binarySearchPosition(dp,nums[i],i);
            dp[pos] = nums[i];
        }
        for(int i = dp.length - 1;i >= 0;i--){
            if(dp[i] != Integer.MAX_VALUE) return i + 1;
        }
        return 0;
    }


    private int binarySearchPosition(int[] dp,int target,int hi){
        int low = 0;
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(target < dp[mid]) hi = mid - 1;
            else if(target >= dp[mid]) low = mid + 1;
        }
        return low;
    }
    
    public boolean checkPossibility(int[] nums) {
        int size = lengthOfLIS(nums);
        return size >=  nums.length - 1;
            
    }
}