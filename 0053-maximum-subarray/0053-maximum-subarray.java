class Solution {
    public int maxSubArray(int[] nums) {
     	int max = nums[0];
		int maxTillNow = nums[0];
		int n = nums.length;
		for(int i=1; i<n; i++){
			maxTillNow += nums[i];
			if(maxTillNow < nums[i]){
				maxTillNow = nums[i];				
			}
			max = Math.max(max, maxTillNow);
		}

		return max;
    }
}


