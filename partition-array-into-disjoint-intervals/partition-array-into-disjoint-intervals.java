class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] lmax = new int[nums.length];
        int[] rmin = new int[nums.length];
        
        int n = nums.length;
        
        lmax[0] = nums[0];
        rmin[n-1] = nums[n-1];
        
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(lmax[i-1], nums[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            rmin[i] = Math.min(rmin[i+1], nums[i]);
        }
        
        System.out.println(Arrays.toString(lmax));
        System.out.println(Arrays.toString(rmin));
        
        for(int i=0;i<n-1;i++){
            if (lmax[i]<=rmin[i+1]){
                return i+1;
            }
        }
        
        return 0;
    }
}