class Solution {
	public static int compare(int [] p1, int [] p2){
		int ret = Integer.compare(p1[0], p2[0]);
		if(ret != 0)
			return ret;

		return Integer.compare(p1[1], p2[1]);
	}

    public int maximumPopulation(int[][] logs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Solution::compare);
		for(int[] log: logs){
			pq.add(new int[]{log[0], 1});
			pq.add(new int[]{log[1], -1});
		}

		int max = 0;
		int year = 0;
        int currMax= 0;
		while(!pq.isEmpty()){
			int[] curr = pq.poll();
            currMax += curr[1];
			if(currMax > max){
				max = currMax;
				year = curr[0];
			}
		}

		return year;
    }
}
