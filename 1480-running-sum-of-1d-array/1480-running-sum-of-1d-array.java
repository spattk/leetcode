class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        int k = 0, sum = 0;
        for(int num: nums){
            sum += num;
            runningSum[k++] = sum;
        }
        
        return runningSum;
    }
}