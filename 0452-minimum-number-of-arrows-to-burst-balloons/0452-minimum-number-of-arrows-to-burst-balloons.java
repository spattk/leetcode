class Solution {
   	 public int findMinArrowShots(int[][] points) {
     	 	Arrays.sort(points, (p1, p2)-> {
           	if(p1[1] > p2[1]) return 1;
			else if (p1[1] < p2[1]) return -1;
			return 0;
        	});

		int arrows = 1;
		int lastEnd = points[0][1];
		int n = points.length;
		for(int i=0; i<n; i++){
			int start = points[i][0];
			int end = points[i][1];

			if(start > lastEnd){
				arrows ++;
				lastEnd = end;
			}
		}

		return arrows;
    }
}

