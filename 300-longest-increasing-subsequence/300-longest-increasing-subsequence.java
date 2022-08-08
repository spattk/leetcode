class Solution {
    
    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }
    
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
        return 0;
        }
        int len = 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > tails[len]){
                tails[++len] = nums[i];
            } else {
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }


}