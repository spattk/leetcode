class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        int window = 0;
        int count = 0;
        int curr = 0;
        while(end < n){
            curr = nums[end];
            if (curr < left){
                //
            } else if (curr >= left && curr <= right) {
                window = (end - start + 1);
            } else if (curr > right){
                window = 0;
                start = end + 1;
            }
            count+= window;
            end++;
        }
        
        return count;
    }
}