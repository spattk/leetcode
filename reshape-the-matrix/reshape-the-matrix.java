class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if (m*n != r*c){
            return mat;
        }
        
        int[][] nmat = new int[r][c];
        int x = 0, y = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                int curr = mat[i][j];
                
                if (y == c){
                    y = 0;
                    x++;
                }
                
                nmat[x][y] = curr;
                y++;
            }
        }
        
        return nmat;
        
    }
}