class Solution {
    
    public int getTotalTrap(int[] height, int[] left, int[] right){
        int sum = 0;
        
        for(int i=0; i<height.length; i++)
            sum += Math.max(0, Math.min(left[i], right[i])- height[i] );
        
        return sum;
    }
    
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = height[0];
        for(int i=1; i<height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        return getTotalTrap(height, left, right);
    }
}