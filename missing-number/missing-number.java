class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0;i<=n;i++){
            result ^= i;
            if(i < nums.length){
                result ^= nums[i];
            }
        }
        
        return result;
    }
}