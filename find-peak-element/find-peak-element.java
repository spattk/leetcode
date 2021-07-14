class Solution {
    
    public int findPeakElement(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;
        int mid;
        int n = nums.length;
        
        if (n==1){
            return 0;
        } else if (n==2){
            return nums[1]>nums[0]?1:0;
        }
        
        while(l<=r){
            mid = l + (r-l)/2;
            if (mid == 0){
                if (nums[mid]>nums[mid+1]){
                    return mid;
                }
                l++;
            }
            else if (mid == n-1) {
                if (nums[mid]>nums[mid-1]){
                    return mid;
                }
                r--;
            }
            else {
                if (nums[mid] > nums[mid-1] && nums[mid]>nums[mid+1]){
                    return mid;
                }
                else {
                    if(nums[mid-1]>nums[mid+1]){
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                }
            }
        }
        
        return -1;
    }
}