class Solution {
    public int totalMoney(int n) {
        int k = n/7;
        int r = n%7;
        
        // return r;
        
        if (k > 0){
            // complete + partial
            return k*28 + (k * (k-1))/2 * 7 + (r * (r+1))/2 + r*k;
        } else {
            return k*28 + (r * (r+1))/2;
        }
        
        
    }
}