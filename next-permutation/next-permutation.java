class Solution {
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i){
        int n = nums.length;
        int j = n-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
        
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){
            int j = n-1;
            while(j>=0 && nums[j] <=nums[i])
                j--;
            // System.out.println(i + " " + j);
            swap(nums, i,j);
            // System.out.println(i + " " + j);
        }
        // System.out.println(i);
        reverse(nums, i+1);
    }
}