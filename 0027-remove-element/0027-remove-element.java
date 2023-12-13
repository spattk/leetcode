class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i =0, j=n-1;
        int count = n;
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1){
            if (nums[0] == val){
                return 0;
            }
            else 
                return 1;
        }
        
            
        while (i <= j) {
            while(j >=0 && nums[j] == val) {
                count--;
                j--;
            }

            if ( i > j)
            break;

            if(nums[i] == val) {
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j--;
                i++;
                count-- ;
            }

            else {
                i++;
            }
        }
        
        
        return count;
    }
}