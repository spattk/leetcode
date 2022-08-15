class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        long l = 1;
        long r = (long) 1e9;
        
        int n = piles.length;
        long ans = (long)Integer.MAX_VALUE;
        
        while(l <= r){
            long mid = l + (r-l )/2;
            int hours = 0;
            for(int i = 0; i<n; i++){
                hours += (int)Math.ceil(piles[i] * 1.0/mid);
                if(hours > h)
                    break;
            }
            
            if(hours > h){
                l = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
            
        }
        
        return (int)ans;
        
    }
}