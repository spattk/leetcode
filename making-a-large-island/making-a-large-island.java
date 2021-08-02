class Solution {
    
    public int getSizeAndUpdate(int[][] grid, int i, int j, int id, int n){
        if (i<0 || j < 0 || i > n-1 || j > n-1 || grid[i][j] !=1 ){
            return 0;
        }
        grid[i][j] = id;
        return 1 + getSizeAndUpdate(grid, i+1, j, id, n) + 
            getSizeAndUpdate(grid, i, j+1, id, n) +
            getSizeAndUpdate(grid, i-1, j, id, n) +
            getSizeAndUpdate(grid, i, j-1, id, n);
        
    }
    
    public boolean isValid(int i, int j, int n){
        if (i<0 || j < 0 || i > n-1 || j > n-1){
            return false;
        }
        
        return true;
    }
    
    public int sumAllNeighbour(int x, int y, int[][] grid, int n, Map<Integer, Integer> map){
        
         Set<Integer> set = new HashSet<>();
        
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny, n)){
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
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int gridId = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == 1){
                    int size = getSizeAndUpdate(grid, i, j, gridId,n);
                    map.put(gridId, size);
                    gridId++;
                }
            }
        }
        
        

        int max = map.getOrDefault(2,0);
        for(int p=0;p<n;p++){
            for(int q=0;q<n;q++){
                if (grid[p][q] == 0){
                    max = Math.max(max, sumAllNeighbour(p,q, grid, n, map));
                }
            }
        }
        
        return max;
    }
}