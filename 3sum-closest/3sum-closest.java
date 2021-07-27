class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int left, right;
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int sum = 0;
        for(int i=0;i<n-2;i++){
            left = i+1;
            right = n-1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < diff){
                    result = sum;
                    diff = Math.abs(target-sum);
                }
                //diff = Math.min(Math.abs(diff-target), Math.abs(nums[i] + nums[left] + nums[right]-target));
                if (sum < target){
                    left ++;
                } else if (sum > target){
                    right--;
                } 
                else {
                    return target;
                }
            }
        }
        
        return result;
        
    }
}