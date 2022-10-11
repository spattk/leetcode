class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        for(int i=0; i<=n-3; i++){
            int temp = Integer.MAX_VALUE;
            int sum = 0;
            int j = i+1, k = n-1;
            while(j < k){
                if((nums[i] + nums[j] + nums[k]) == target){
                    return target;
                } else if((nums[i] + nums[j] + nums[k]) < target) {
                    sum = (nums[i] + nums[j] + nums[k]);
                    j++;
                    
                    if(Math.abs(target - sum) < Math.abs(target - temp)){
                        temp = sum;
                    }
                } else {
                    sum = (nums[i] + nums[j] + nums[k]);
                    k--;
                    
                    if(Math.abs(target - sum) < Math.abs(target - temp)){
                        temp = sum;
                    }
                }
            }
            
            if(Math.abs(target - temp) < Math.abs(target - closest)){
                closest = temp;
            }
        }
        
        return closest;
    }
}