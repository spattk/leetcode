class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] first = new int[n];
        int[] last = new int[n];
        
        first[0] = cardPoints[0];
        int total = cardPoints[0];
        for(int i = 1; i<n;i++){
            total += cardPoints[i];
            first[i] = first[i-1] + cardPoints[i];
        }
        
        last[n-1] = cardPoints[n-1];
        for(int i=n-2; i>=0; i--){
            last[i] = last[i+1] + cardPoints[i];
        }
        
        // System.out.println(Arrays.toString(first));
        // System.out.println(Arrays.toString(last));
        
        int max = 0;
        for(int left = k; left >=0; left--){
            // System.out.println("l " + left);
            int curr = 0;
            
            if(left > 0) {
                curr = first[left-1];
            }
            // System.out.println("curr " + curr);
            
            if(k - left > 0 ){
                curr += last[n - (k - left)];
            }
            
            // System.out.println("curr " + curr);
            max = Math.max(max, curr);
        }
        
        return max;
    }
}