class Solution {
    public int[][] transpose(int[][] matrix) {
        
        int x = matrix.length;
        int y = matrix[0].length;
        
        int[][] mat = new int[y][x];
        
        for(int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                mat[i][j] = matrix[j][i];
            }
        }
        
        return mat;
    }
}