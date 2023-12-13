class Solution {
    
    public void invertUtil(int[] nums, int start, int end) {
        
        if(start < 0 || end < 0)
            return;
        
        while (start  < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        if(k == 0)
            return;
        
        int n = nums.length;
        k = k%n;
        
        //rotate right half
        invertUtil(nums, n-k, n-1);
        
        //rotate left half
        invertUtil(nums, 0, n-k-1);
        
        //rotate whole
        invertUtil(nums, 0, n-1);
    }
}