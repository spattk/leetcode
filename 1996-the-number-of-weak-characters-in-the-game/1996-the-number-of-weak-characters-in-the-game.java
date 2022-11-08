class Solution {
	//defense to list of pairs
	Map<Integer, List<int[]>> map;
	int maxD = -1, maxA = -1, count = 0;
	
	public void fillMap(int[][] properties){
		for(int []p: properties){
			map.putIfAbsent(p[1], new ArrayList<>());
			map.get(p[1]).add(p);
			maxD = Math.max(maxD, p[1]);
		}
	}

	public void processFromMaxD(){
		while(maxD >= 0){
			if(map.get(maxD) != null){
				int currMax = -1;
				for(int[] ele: map.get(maxD)){
					if(maxA != -1 && ele[0] < maxA){
						count++;
					}
					currMax = Math.max(currMax, ele[0]);
				}

				maxA = Math.max(maxA, currMax);
			}
			maxD--;
		}
	}

    	public int numberOfWeakCharacters(int[][] properties) {
     		map = new HashMap<>();
		fillMap(properties);
		processFromMaxD();
		return count;
    	}
}

