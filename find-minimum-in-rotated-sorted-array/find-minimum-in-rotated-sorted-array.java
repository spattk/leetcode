class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int left = 0;
        int right = n-1;
        while(left <= right){
            
            int mid = (left + right )/2;
            // System.out.println(mid);
            if(mid == 0){
                if (nums[mid]<nums[mid+1]){
                    return nums[mid];
                } else{
                    return nums[mid+1];
                }
            } else if (mid == n-1) {
                if (nums[mid]<nums[mid-1]){
                    return nums[mid];
                } else{
                    return nums[mid-1];
                }
            } else {
                if (nums[mid]< nums[mid-1] && nums[mid] < nums[mid+1]){
                    return nums[mid];
                } else if (nums[mid] < nums[right]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}