class Solution {
    
    public int[] getEvenSum(int [] nums, int [][] queries, int oddSum, int evenSum){
        int nq = queries.length;
        int[] result = new int[nq];
        
        for(int i=0; i<nq; i++){
            int idx = queries[i][1];
            int val = queries[i][0];
            
            int prevVal = nums[idx];
            if(prevVal %2 == 0){
                evenSum -= prevVal;
            } else {
                oddSum -= prevVal;
            }
            
            nums[idx] = prevVal + val;
            
            if(nums[idx] %2 == 0)
                evenSum += nums[idx];
            else
                oddSum += nums[idx];
            
            result[i] = evenSum;
        }
        
        return result;
    }
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0, oddSum = 0;
        for(int num: nums){
            if(num%2 == 0)
                evenSum += num;
            else
                oddSum += num;
        }
        
        return getEvenSum(nums, queries, oddSum, evenSum);
    }
}