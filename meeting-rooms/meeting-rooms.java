class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));
        
        int n = intervals.length;
        if(n <= 1)
            return true;
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i=1;i<n;i++){
            if(intervals[i][0]<end){
                return false;
            }
            start = intervals[i][0];
            end = intervals[i][1];
        }
        
        return true;
    }
}