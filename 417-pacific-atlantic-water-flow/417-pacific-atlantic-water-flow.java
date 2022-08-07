class Solution {
    
    int[][] dx = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    public void generateList(Set<String> set, List<List<Integer>> result) {
        for(String str: set){
            String[] arr = str.split(",");
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(arr[0]));
            temp.add(Integer.parseInt(arr[1]));
            result.add(temp);
        }
    }
    
    Set<String> set = new HashSet<>();
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        
        List<List<Integer>> result = new ArrayList<>();
    
        boolean[][] atlantic = new boolean[r][c];
        boolean[][] pacific = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<r; i++){
            q.add(new int[]{i, c-1});
        }
        
        for(int j=0; j<c;j++){
            q.add(new int[]{r-1, j});
        }
        
        
        //for atlantic
        while(!q.isEmpty()){
            int[] curr = q.poll();
            atlantic[curr[0]][curr[1]] = true;
            
            for(int i=0;i<4;i++){
                int nx = curr[0] + dx[i][0];
                int ny = curr[1] + dx[i][1];
                
                if(isSafe(nx,ny,r,c) && heights[nx][ny] >= heights[curr[0]][curr[1]] && !atlantic[nx][ny]){
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        // for(int i=0;i<r;i++)
        //     System.out.println(Arrays.toString(atlantic[i]));
        
        
        
        //for pacific
        
        q = new LinkedList<>();
        
        for(int i=0; i<r; i++){
            q.add(new int[]{i, 0});
        }
        
        for(int j=0; j<c;j++){
            q.add(new int[]{0, j});
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            // System.out.println("--- " + Arrays.toString(curr));
            pacific[curr[0]][curr[1]] = true;
            if(atlantic[curr[0]][curr[1]]){
                set.add(curr[0] + "," + curr[1]);
            }
            
            for(int i=0;i<4;i++){
                int nx = curr[0] + dx[i][0];
                int ny = curr[1] + dx[i][1];
                
                if(isSafe(nx,ny,r,c) && heights[nx][ny] >= heights[curr[0]][curr[1]] && !pacific[nx][ny]){
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        // for(int i=0;i<r;i++)
        //     System.out.println(Arrays.toString(pacific[i]));
        
        //intersection
        generateList(set, result);
        return result;
    }
}