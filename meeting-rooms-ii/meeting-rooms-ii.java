class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i=0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 0;
        int j = 0;
        int count = 0;
        int max =0;
        while(i < n && j < n){
            if(start[i] < end[j]){
                count++;
                i++;
            } else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}