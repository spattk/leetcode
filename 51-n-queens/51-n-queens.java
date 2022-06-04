class Solution {
    
    List<List<String>> result = new ArrayList<>();
    int[][] queens;
    
    public boolean isSafe(int row, int col, int n){
        
        if(row >= n || row < 0 || col >= n || col < 0)
            return false;
        
        //check row
        for(int j=0;j<n;j++){
            if(j == col)
                continue;
            if(queens[row][j] == 1)
                return false;
        }
        
        //check col
        for(int i=0;i<n;i++){
            if(i == row)
                continue;
            if(queens[i][col] == 1)
                return false;
        }
        
        
        //check diag
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(((i + j) == (row + col)) && queens[i][j] == 1){
                    return false;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(((i - j) == (row - col)) && queens[i][j] == 1){
                    return false;
                }
            }
        }
        
    
        return true;
    }
    
    public void solveNQueensUtil(int n, int row){
        if(row == n){
            List<String> ans = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                String temp = "";
                for(int j=0;j<n;j++){
                    if(queens[i][j] == 1){
                        temp += "Q";
                    } else {
                        temp += ".";
                    }
                }
                ans.add(temp);
            }
            
            result.add(new ArrayList<>(ans));
            return;
        }
        
        for(int col= 0; col < n; col ++){
            if(isSafe(row, col, n)){
                queens[row][col] = 1;
                solveNQueensUtil(n, row+1);
                queens[row][col] = 0;
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        queens = new int[n][n];
        solveNQueensUtil(n, 0);
        
        return result;
    }
}