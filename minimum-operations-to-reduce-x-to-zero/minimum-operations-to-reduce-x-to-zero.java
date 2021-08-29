class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num: nums)
            sum += num;
        
        int target = sum - x;
        if (target == 0){
            return nums.length;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int temp = 0;
        int res = Integer.MIN_VALUE;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            temp += nums[i];
            if (map.get(temp-target)!=null){
                res = Math.max(res, i - map.get(temp-target));
            }
            
            map.put(temp, i);
        }
        
        if (res == Integer.MIN_VALUE){
            return -1;
        } else {
            return n - res;
        }
    }
}