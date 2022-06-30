class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = 0;
        if(n % 2 ==0 ){
            median = (nums[n/2] + nums[n/2 - 1])/2;
        } else {
            median = nums[n/2];
        }
        
        int result = 0;
        for(int num: nums){
            result += Math.abs(num-median);
        }
        
        return result;
    }
}