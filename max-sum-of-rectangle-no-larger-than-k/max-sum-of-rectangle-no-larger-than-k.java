class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int r= matrix.length;
        int c = matrix[0].length;
        
        int result = Integer.MIN_VALUE;
        
        for(int i=0;i<r;i++){
            int[] colSum = new int[c];
            for(int j=i;j<r;j++){
                for(int col=0;col<c;col++){
                    colSum[col] += matrix[j][col];
                }
                result = Math.max(result, find(colSum, k));
                if (result == k){
                    return result;
                }
            }
        }
        
        return result;
        
    }
    
    private int find(int[] sum, int k) {
    int result = Integer.MIN_VALUE;
    TreeSet<Integer> set = new TreeSet<>();
    set.add(0);
    int prefixSum = 0;
    for(int i = 0; i < sum.length; i++) {
      prefixSum += sum[i];

      Integer target = set.ceiling(prefixSum - k);

      if(target != null) {
        result = Math.max(result, prefixSum - target);
      }
      set.add(prefixSum);
    }

    return result;
  }
}