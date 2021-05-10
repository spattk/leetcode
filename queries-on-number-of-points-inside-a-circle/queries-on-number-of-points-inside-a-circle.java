class Solution {
    
    public int distance(int x1, int y1, int x2, int y2){
        return (int) Math.ceil(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2)));
    }
    
    public int[] countPoints(int[][] points, int[][] queries) {
        int []result = new int[queries.length];
        int count;
        for(int i=0;i<queries.length;i++){
            count = 0;
            for(int j=0;j<points.length;j++){
                if (distance(points[j][0], points[j][1], queries[i][0], queries[i][1]) <= queries[i][2]) {
                    count ++;
                }
            }
            result[i] = count;
        }
        return result;
        
    }
}