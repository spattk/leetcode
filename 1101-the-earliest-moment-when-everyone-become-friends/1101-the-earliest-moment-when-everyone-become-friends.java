class Solution {
	int[] parent;
	int[] rank;
	int count;

	public void initDisjointSet(int n){
		parent = new int[n];
		rank = new int[n];

		for(int i=0; i<n; i++){
			parent[i] = i;
		}
		count = n;
	}

	public void union(int u, int v){
		int pu = findParent(u);
		int pv = findParent(v);

		if(pu != pv){
			int ru = rank[pu];
			int rv = rank[pv];

			if(ru < rv){
				parent[pu] = pv;
			}
			else if (rv < ru) {
				parent[pv] = pu;
			}
	
			else {
				parent[pv] = pu;
				rank[pu]++;
			}

			count-=1;	
		
		}
	}

	public int findParent(int u){
		if(parent[u] != u){
			parent[u] = findParent(parent[u]);
		}
		return parent[u];
	}

    public int earliestAcq(int[][] logs, int n) {
		Arrays.sort(logs, (a,b) -> a[0] - b[0]);
		initDisjointSet(n);

		int len = logs.length;  

		for(int i=0; i<len; i++){
			
			union(logs[i][1], logs[i][2]);
			if(count == 1){
				return logs[i][0];
			}
		}

		return -1;
    }
}

