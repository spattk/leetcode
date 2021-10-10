class Solution {
    
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int n = intervals.length;
        if(n<=1)
            return intervals;
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> result= new ArrayList<>();
        
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        result.add(new int[]{start, end});
        
        return result.toArray(new int[result.size()][]);
    }
}