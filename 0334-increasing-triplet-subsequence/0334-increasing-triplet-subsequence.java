class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        
        tail[0] = nums[0];
        int length = 1;
        
        for(int i=1; i<n; i++){
            if(nums[i] > tail[length-1]){
                tail[length++] = nums[i];
            } else {
                int idx = Arrays.binarySearch(tail, 0, length - 1, nums[i]);
                if(idx < 0) {
                    idx = -1 * idx - 1;
                }
                
                tail[idx] = nums[i];
            }
            
            if(length >= 3)
                return true;
        }
        
        return false;
    }
}