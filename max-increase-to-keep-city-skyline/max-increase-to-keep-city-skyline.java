class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        
        for(int i=0;i<row.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<col.length;j++){
                max = Math.max(grid[i][j], max);
            }
            row[i] = max;
        }
        
        for(int j=0;j<col.length;j++){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<row.length;i++){
                max = Math.max(grid[i][j], max);
            }
            col[j] = max;
        }
        
        int sum = 0;
        for(int i=0;i<row.length;i++){
            for (int j=0;j<col.length;j++){
                sum += Math.abs(Math.min(row[i], col[j])-grid[i][j]);
            }
        }
        return sum;
    }
}