class Solution {
    
    public int getMax(int[]left, int[] right, int [] heights){
        int max = 0;
        for(int i=0; i<heights.length; i++){
            max = Math.max(max, Math.max(0, right[i] - left[i] -1 ) * heights[i]);
        }
        
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        left[0] = -1;
        st.push(0);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            
            if(st.isEmpty()){
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }
            
            st.push(i);
        }
        // System.out.println(Arrays.toString(left));
        
        
        st = new Stack<>();
        right[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && (st.peek() == n ||  heights[st.peek()] >= heights[i]))
                st.pop();
            
            if(st.isEmpty()){
                right[i] = n;
            } else {
                right[i] = st.peek();
            }
            
            st.push(i);
        }
        
        // System.out.println(Arrays.toString(right));
        
        return getMax(left, right, heights);
    }
}