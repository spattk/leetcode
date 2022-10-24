class Solution {
	public long distSq(int [] p, int [] q){
		return ( (long)(Math.pow((p[0] - q[0]), 2) + (long)(Math.pow((p[1] - q[1]), 2))));
	}

	public boolean checkDist(Map<Long, List<int[]>> distMap){
		if(distMap.size() != 2)
			return false;

		int count2 = 0 , count4 = 0;
		for(long key: distMap.keySet()){
			if(distMap.get(key).size() == 2 ){
				count2++;
			}

			if(distMap.get(key).size() == 4 ){
				count4++;
			}
		}

		return count2 == 1 && count4 == 1;
	}

	public boolean checkAngles(Map<Long, List<int[]>> distMap, int[][]points){
		long dist2sq = 0, dist4sq = 0;

		for(long key: distMap.keySet()){
			if(distMap.get(key).size() == 2){
				int[] curr = distMap.get(key).get(0);
				dist2sq = distSq(points[curr[0]], points[curr[1]]);
			}

			if(distMap.get(key).size() == 4){
				int[] curr = distMap.get(key).get(0);
				dist4sq = distSq(points[curr[0]], points[curr[1]]);
			}
		}
        
        // System.out.println(dist2sq + " " + dist4sq);

		return 2 * dist4sq == dist2sq;
	}
	
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    	Map<Long, List<int[]>> distMap = new HashMap<>();
        
		int[][] points = new int[4][2];
        
		points[0] = p1;
		points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        
		for(int i=0; i<4; i++){
			for(int j=i+1; j<4; j++){
                
				long dist = distSq(points[i], points[j]);
				distMap.putIfAbsent(dist, new ArrayList<>());
				distMap.get(dist).add(new int[]{i,j});
			}
		}
        
        // System.out.println(distMap);
            
		if(!checkDist(distMap))
			return false;

		if(!checkAngles(distMap, points))
			return false;

		return true;
    }
}


