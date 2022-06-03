class NumMatrix {

    int [][] sumMatrix;
    int r, c;
    
    public NumMatrix(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        
        sumMatrix = new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(j == 0){
                    sumMatrix[i][j] = matrix[i][j];
                } else {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // System.out.println("--------------");
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         System.out.print(sumMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("--------------");
        int sum = 0;
        for(int i=row1; i<=row2;i++){
            if(col1 != 0){
                sum += sumMatrix[i][col2] - sumMatrix[i][col1-1];
            } else {
                sum += sumMatrix[i][col2];
            }
            
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */