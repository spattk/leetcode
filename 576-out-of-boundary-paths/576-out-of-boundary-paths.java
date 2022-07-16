class Solution {
    Long[][][] memo = null;
    
    int mod = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int sr, int sc) {
        memo = new Long[m + 1][n + 1][maxMove + 1];
        return (int)helper(m,n,maxMove,sr,sc);
    }
    
    long helper(int r, int c, int move, int x, int y){
        if(move < 0)
            return 0;
        
        if(x<0 || x>=r || y<0 || y>=c)
            return 1;
        
        if(memo[x][y][move] != null)
            return memo[x][y][move];
        
        long left = helper(r, c, move - 1, x, y-1);
        long right = helper(r, c, move - 1, x, y + 1);
        long top = helper(r, c, move - 1, x-1, y);
        long bottom = helper(r, c, move - 1, x+1, y);
        
        long total = (left + right + top + bottom) % mod;
        
        memo[x][y][move] = total;
        return total;
    }
}