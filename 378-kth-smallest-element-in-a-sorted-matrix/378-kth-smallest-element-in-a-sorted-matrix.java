class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        
        while(min < max){
            int mid = min + (max - min)/2;
            int r = rank(matrix, mid);
            if(r < k)
                min = mid + 1;
            else
                max = mid;
        }
        
        return min;
    }
    
    public int rank(int[][] matrix, int ele){
        int n = matrix.length;
        int i = 0, j = n-1;
        int count = 0;
        while(i < n && j >= 0) {
            if(matrix[i][j]<=ele){
                count += (j+1);
                i++;
            } else {
                j--;
            }
        }
        
        
        return count;
    }
}