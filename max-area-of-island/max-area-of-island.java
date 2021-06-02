class Solution {
    
    Set<String> set;
    int max = 0;
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    int currSum = 0;
    
    public boolean isSafe(int i, int j, int m, int n){
        if (i<0 || i >=m || j <0 || j >=n) {
            return false;
        }
        
        if (set.contains("" + i+ "," + j)){
            return false;
        }
        
        return true;
    }
    
    public void dfs(int i, int j, int m, int n, int[][] grid){
        if (i<0 || i >=m || j <0 || j >=n || grid[i][j] != 1){
            return;
        }
        currSum += 1;
        max = Math.max(max, currSum);
        set.add("" + i + "," + j);
        
        for(int z=0;z<4;z++){
            int ni = i + dx[z];
            int nj = j + dy[z];
            if (isSafe(ni, nj, m,n) && grid[ni][nj] == 1){
                dfs(ni, nj, m, n, grid);
            }
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                currSum = 0;
                if (!set.contains("" + i + "," + j) && grid[i][j] == 1){
                    dfs(i,j,m,n,grid);
                }
            }
        }
        return max;
    }
}