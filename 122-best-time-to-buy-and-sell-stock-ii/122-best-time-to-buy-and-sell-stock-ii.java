class Solution {
    public int maxProfit(int[] ar) {
        int sum = 0, n = ar.length;
        for(int i=1;i<n;i++){
            if(ar[i]>ar[i-1]){
                sum += ar[i] - ar[i-1];
            }
        }
        
        return sum;
    }
}