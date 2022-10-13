class TicTacToe {

    int[][] mat;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        mat = new int[n][n];
    }
    
    public boolean horizontalPass(int row, int col, int p){
        for(int i=0; i<n; i++){
            if(mat[row][i] != p)
                return false;
        }
        
        return true;
    }
    
    public boolean verticalPass(int row, int col, int p){
        for(int i=0; i<n; i++){
            if(mat[i][col] != p)
                return false;
        }
        
        return true;
    }
    
    public boolean leftDiagPass(int row, int col, int p){
        
        int count = 0;
        
        int r = row, c = col;
        while(r>=0 && c>=0){
            if(mat[r][c] == p)
                count++;
            
            r--;
            c--;
        }
        
        r = row; c = col;
        while(r < n && c<n){
            if(mat[r][c] == p)
                count++;
            
            r++;
            c++;
        }
        
        return count == (n + 1);
    }
    
    public boolean rightDiagPass(int row, int col, int p){
        
        int count = 0;
        
        int r = row, c = col;
        while(r>=0 && c<n){
            if(mat[r][c] == p)
                count++;
            
            r--;
            c++;
        }
        
        r = row; c = col;
        while(r < n && c>=0){
            if(mat[r][c] == p)
                count++;
            
            r++;
            c--;
        }
        
        return count == (n+1);
    }
    
    public int move(int row, int col, int p) {
        mat[row][col] = p;
        
        if((horizontalPass(row, col, p) || verticalPass(row, col, p) || leftDiagPass(row, col, p)) || rightDiagPass(row, col, p)){
            return p;
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */