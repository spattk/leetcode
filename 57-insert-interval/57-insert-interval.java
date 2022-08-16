class Solution {
    
    public int[][] convertToList(Stack<int[]> st){
        int n = st.size();
        int[][] result = new int[n][2];
        while(!st.isEmpty()){
            result[--n] = st.pop();
        }
        
        return result;
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> st = new Stack<>();
        int n = intervals.length;
        
        int[][] result = new int[n+1][2];
        int k = 0;
        for(int[] ele: intervals)
            result[k++] = ele;
        
        result[k++] = newInterval;
        Arrays.sort(result, (p,q) -> p[0]-q[0]);
        
        st.add(result[0]);
        
        for(int i=1; i<=n; i++){
            int[] curr = st.pop();
            if(result[i][0] <= curr[1]){
                curr[0] = Math.min(curr[0], result[i][0]);
                curr[1] = Math.max(curr[1], result[i][1]);
                st.add(curr);
            } else{
                st.add(curr);
                st.add(result[i]);
            }
        }
        
        return convertToList(st);
    }
}