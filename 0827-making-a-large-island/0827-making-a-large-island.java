class Solution {
    
    int[][]dx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int n;
    
    public void dfs(int[][] grid, int i, int j, int id, Set<Pair<Integer, Integer>> count){
        
        grid[i][j] = id;
        count.add(new Pair(i,j));
        
        for(int k=0; k<4; k++){
            int nx = i + dx[k][0];
            int ny = j + dx[k][1];
            
            if(isValid(nx, ny) && grid[nx][ny] == 1){
                dfs(grid, nx, ny, id, count);
            }
        }
        
    }
    
    public boolean isValid(int i, int j){
        return i>=0 && j >= 0 &&  i < n && j < n;
    }
    
    public int sumAllNeighbour(int x, int y, int[][] grid, Map<Integer, Integer> map){
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<4;i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            if (isValid(nx, ny)){
                set.add(grid[nx][ny]);
            }
        }
        
        int sum = 1;
        for(int num: set){
            sum += map.get(num);
        }
        
        return sum;
        
    }
    
    public int largestIsland(int[][] grid) {
        n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int gridId = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == 1){
                    Set<Pair<Integer, Integer>> count = new HashSet<>();
                    dfs(grid, i, j, gridId, count);
                    map.put(gridId, count.size());
                    gridId++;
                }
            }
        }
        
        
        int max = map.getOrDefault(2,0);
        for(int p=0;p<n;p++){
            for(int q=0;q<n;q++){
                if (grid[p][q] == 0){
                    max = Math.max(max, sumAllNeighbour(p,q, grid, map));
                }
            }
        }
        
        return max;
    }
}