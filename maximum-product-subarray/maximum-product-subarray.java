class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        for(int num: nums){
            result = Math.max(result, num);
        }
        int max = 1, min = 1;
        for(int n: nums){
            if(n == 0){
                max = 1; min = 1;
                continue;
            }
            
            int temp = max;
            max = Math.max(max*n, Math.max(min*n, n));
            min = Math.min(temp*n, Math.min(min*n, n));
            
            result = Math.max(result,max);
        }
        return result;
    }
}