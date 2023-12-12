class Solution {
    public int maxProduct(int[] nums) {
        int firstPos = -1, secondPos = -1;
        int first = 0, second = 0;
        
        for (int i=0; i<nums.length; i++) {
            if(nums[i]> first){
                first = nums[i];
                firstPos = i;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if(nums[i] > second && i != firstPos){
                second = nums[i];
                secondPos = i;
            }
        }
        
        
        return (first - 1) * (second - 1);
    }
}