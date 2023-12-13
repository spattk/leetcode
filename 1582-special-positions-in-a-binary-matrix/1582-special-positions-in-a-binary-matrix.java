class Solution {
    
    
    int r = 0;
    int c = 0;
    
    public int countSpecial(int[][]mat, int[] row, int [] col) {
        
        int count = 0;
        
        for(int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if(mat[i][j] == 1) {
                    if (row[j] == 1 && col[i] == 1) {
                        count ++;
                    }
                }
            }
        }
        
        return count;
    }
    
    public int numSpecial(int[][] mat) {
        r = mat.length;
        c = mat[0].length;
        
        int[] row = new int[c];
        int[] col = new int[r];
        
        for(int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                row[j] += mat[i][j];
                col[i] += mat[i][j];
            }
        }
        
        return countSpecial(mat, row, col);
    }
}