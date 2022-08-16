class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int []b){
               int ret = Integer.compare(a[1],b[1]);
               if(ret != 0){
                   return ret;
               }
               
               return Integer.compare(a[0],b[0]);
           }
        });
        
        int n = intervals.length;
        
        if(n == 0)
            return true;
        
        
        for(int i=1; i<n; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        
        return true;
    }
}