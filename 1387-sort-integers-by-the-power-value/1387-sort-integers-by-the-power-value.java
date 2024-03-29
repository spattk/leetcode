class Solution {
     	
    Map<Integer, Integer> dp;
	public static int compare(int[] p, int q[]){
		int ret = Integer.compare(p[1],q[1]);
		if(ret != 0)
			return ret;

		return Integer.compare(p[0], q[0]);
	}
        
	public int getSteps(int num){
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{num, 0});
		Set<Integer> visited = new HashSet<>();
		visited.add(num);
		while(!q.isEmpty()){
			int[] curr = q.poll();
        
            
			if(curr[0] == 1) {
				return curr[1];
            }
            
            if(dp.get(curr[0]) != null){
                return curr[1] + dp.get(curr[0]);
            }
                
                
			int temp = curr[0];
			int count = curr[1];

			if(temp % 2 == 0){
				if(!visited.contains(temp/2)){
					visited.add(temp/2);
					q.add(new int[]{temp/2, count + 1});
				}
			}

			else {
				if(!visited.contains(temp * 3 + 1)){
					visited.add(temp*3 + 1);
					q.add(new int[]{temp * 3 + 1, count + 1});
				}

			}
		}

		return -1;
	}
	
    public int getKth(int lo, int hi, int k) {
        dp = new HashMap<>();
     	List<int[]> list = new ArrayList<>();
		for(int i=lo; i<=hi; i++){
            int steps = getSteps(i);
            dp.put(i, steps);
			list.add(new int[]{i, steps});
		}   

		Collections.sort(list, Solution::compare);
		return list.get(k-1)[0];
    }
}


