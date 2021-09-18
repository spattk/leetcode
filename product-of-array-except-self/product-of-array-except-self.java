class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lm = new int[n];
        int[] rm = new int[n];
        
        lm[0] = 1;
        for(int i=1;i<n;i++){
            lm[i] = lm[i-1] * nums[i-1];
        }
        
        rm[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            rm[i] = rm[i+1] * nums[i+1];
        }
        
        
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i] = lm[i] * rm[i];
        }
        
        return result;
        
    }
}