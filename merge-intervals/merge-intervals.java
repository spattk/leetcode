class Solution {
    public int[][] convert(Stack<int[]> st){
        int n = st.size();
        int[][] result = new int[n][2];
        for(int i=n-1;i>=0;i--){
            result[i] = st.pop();
        }
        
        return result;
    }
    
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int [] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        Stack<int[]> st = new Stack<>();
        st.add(intervals[0]);
        
        int n = intervals.length;
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= st.peek()[1]){
                int[] temp = st.pop();
                st.add(new int[] {Math.min(temp[0], intervals[i][0]), 
                                 Math.max(temp[1], intervals[i][1])});
            } else {
                st.add(intervals[i]);
            }
        }
        
        return convert(st);
    }
}