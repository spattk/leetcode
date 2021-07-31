class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lh = new int[n];
        int[] rh = new int[n];
        
        if (n==0 || n == 1 || n == 2){
            return 0;
        }
        
        lh[0] = height[0];
        rh[n-1] = height[n-1];
        
        int temp = lh[0];
        for(int i=1;i<n;i++){
            lh[i] = Math.max(height[i-1], temp);
            temp = Math.max(temp, lh[i]);
        }
        
        temp = rh[n-1];
        for(int i=n-2;i>=0;i--){
            rh[i] = Math.max(height[i+1], temp);
            temp = Math.max(temp, rh[i]);
        }
        System.out.println(Arrays.toString(lh));
        System.out.println(Arrays.toString(rh));
        
        
        int sum = 0;
        for(int i=1;i<n-1;i++){
            if (Math.min(lh[i], rh[i]) - height[i] > 0){
                sum += Math.min(lh[i], rh[i]) - height[i];
            }
        }
        return sum;
    }
}