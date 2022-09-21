class Solution {
    
    public boolean isValidCell(char[][] board, int x, int y){
        
        //row
        for(int i=0; i<9; i++){
            if(i != y){
                if(board[x][i] == board[x][y])
                    return false;
            }
        }
        
        //col
        for(int i=0; i<9; i++){
            if(i != x){
                if(board[i][y] == board[x][y])
                    return false;
            }
        }
        
        //small box
        int tx = x/3;
        int ty = y/3;
        for(int i=3*tx; i<3*tx+3; i++){
            for(int j=3*ty; j<3*ty+3; j++){
                if(i == x && j == y) 
                   continue;
                   
                if(board[i][j] == board[x][y])
                    return false;
            }
        }
        
        return true;
        
    }
    
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && !isValidCell(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}