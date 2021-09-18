class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1){
            return 0;
        }
        int[] max = new int[n];
        max[n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            max[i] = Math.max(max[i+1], prices[i]);
        }
        
        int profit = 0;
        for(int i=0;i<n;i++){
            profit = Math.max(profit, max[i]-prices[i]);
        }
        
        return profit;
    }
}