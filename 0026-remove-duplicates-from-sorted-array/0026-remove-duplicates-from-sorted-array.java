class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1, n = nums.length;
        int prev = nums[0];
        while(j < n){
            if(nums[j] == prev){
                j++;
            }
            else {
                nums[i++] = nums[j];
                prev = nums[j];
                j++;
            }
        }
        
        return i;
    }
}