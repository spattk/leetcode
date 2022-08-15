class Solution {
    
    public int search(int[] nums, int target, int l, int r){
        int mid = l + (r - l)/2;
        int n = nums.length;
        
        if(mid < n && nums[mid] == target)
            return mid;
        
        if(l <= r) {
            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target <= nums[mid])
                    return search(nums, target, l, mid);
                else
                    return search(nums, target, mid+1, r);
            } else {
                if(target > nums[mid] && target <= nums[r])
                    return search(nums, target, mid+1, r);
                else
                    return search(nums, target, l, mid);
            }
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        return search(nums, target, l, r);
    }
}