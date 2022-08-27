class Solution {
    
    public int maxSumArray(int[] arr, int k){
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        int currSum = 0;
        for(int num: arr){
            currSum += num;
            Integer gap = set.ceiling(currSum - k);
            if(gap != null){
                max = Math.max(max, currSum - gap);
            }
            set.add(currSum);
        }
        
        return max;
    }
    
    int result = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int startRow=0; startRow<r; startRow++){
            int[] rowArray = new int[c];
            for(int currRow = startRow; currRow<r; currRow++){
                for(int col=0; col<c; col++){
                    rowArray[col] += matrix[currRow][col];
                }
                result = Math.max(result, maxSumArray(rowArray, k));
            }
        }
        
        return result;
    }
    
    
}