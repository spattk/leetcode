class Solution {
	int r, c;
	int[][] dx = {{-1, 0}, {1,0}, {0,1}, {0, -1}};
	
	public boolean isSafe(int x, int y){
		return x>=0 && x<r && y>=0 && y<c;
	}
		
    	public int minimumEffortPath(int[][] heights) {
		r = heights.length;
		c = heights[0].length;

		PriorityQueue<int[]> pq = new PriorityQueue<>((p,q) -> p[2] - q[2]);
		pq.add(new int[]{0,0,0});
		
		Set<Pair<Integer, Integer>> visited = new HashSet<>();
		while(!pq.isEmpty()){
			int[] curr = pq.poll();
			if(curr[0] == r-1 && curr[1] == c-1){
				return curr[2];
			}


			int x = curr[0];
			int y = curr[1];
            
			visited.add(new Pair(x, y));

			for(int i=0; i<dx.length; i++){
				int nx = x + dx[i][0];
				int ny = y + dx[i][1];

				if(isSafe(nx, ny) && !visited.contains(new Pair(nx, ny))){
					pq.add(new int[]{nx, ny, Math.max(curr[2], Math.abs(heights[nx][ny] - heights[x][y]))});
				}
			}
		}

		return -1;
    	}
}

