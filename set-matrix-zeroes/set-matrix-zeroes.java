class Solution {
    
    public void setRowZeroes(int[][] matrix, int r){
        int n = matrix[0].length;
        for(int i=0;i<n;i++)
            matrix[r][i] = 0;
    }
    
    public void setColZeroes(int[][] matrix, int c){
        int n = matrix.length;
        for(int i=0;i<n;i++)
            matrix[i][c] = 0;
    }
    
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++){
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        
        for(int n: rows){
            setRowZeroes(matrix, n);
        }
        
        for(int n: cols){
            setColZeroes(matrix, n);
        }
    }
}