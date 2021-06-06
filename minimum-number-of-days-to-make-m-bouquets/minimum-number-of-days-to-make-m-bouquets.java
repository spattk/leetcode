class Solution {
    
    public boolean isValid(int[] bloomDay, int m, int k, int mid ){
        int count = 0;
        int ele = 0;
        for(int num: bloomDay){
            if (num <= mid){
                //
                count ++;
                if (count == k){
                    ele ++;
                    count = 0;
                }
            } else {
                //reset the counter
                count = 0;
            }
        }
        
        if (ele >= m){
            return true;
        }
        
        return false;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        for(int num: bloomDay){
            start = Math.min(start, num);
            end = Math.max(end, num);
        }
        
        int result = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if (isValid(bloomDay, m, k, mid)){
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return result;
    }
}