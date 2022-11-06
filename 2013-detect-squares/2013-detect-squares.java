class DetectSquares {

    	Map<Pair<Integer, Integer>, Integer> map;
    	public DetectSquares() {
       	map = new HashMap<>();
    	}
    
    	public void add(int[] point) {
        	Pair pair = new Pair(point[0], point[1]);
		map.put(pair, map.getOrDefault(pair, 0) + 1);
    	}

	public boolean isDiagonal(int x1, int y1, int x2, int y2){
        boolean same = (x1 == x2 && y1 == y2);
		return !same && Math.abs(x1 - x2) == Math.abs(y1-y2);
	}
    
    	public int count(int[] point) {
		int px = point[0];
		int py = point[1];
		int sum = 0;
      	for(Pair<Integer, Integer> pair: map.keySet()){
			if(isDiagonal(px, py, pair.getKey(), pair.getValue())){
				sum += map.getOrDefault(new Pair(px, pair.getValue()), 0) 
						* map.getOrDefault(new Pair(pair.getKey(), pair.getValue()), 0)
						* map.getOrDefault(new Pair(pair.getKey(), py), 0);
			}
		}

		return sum;
    	}
}


