class Solution {
    	public boolean checkSubarraySum(int[] nums, int k) {
     		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0,0);

		for(int i=0; i<nums.length; i++){
			sum += nums[i];
			if(map.get(sum % k) == null){
				map.put(sum%k, i+1);
			}
			else {
				int prev = map.get(sum%k);
				if(i - prev >= 1){
					return true;
				}
			}
		}

		return false;
    	}
}
