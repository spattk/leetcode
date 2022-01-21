class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        
        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<st.peek()[1]){
                count++;
            }else{
                st.push(intervals[i]);
            }
        }
        
        return count;
    }
    
}