class Solution {
    
    public void fillArray(char[] chrs, int[] arr, int dir){
        Stack<int[]> st = new Stack<>();
        int n = chrs.length;
        if(dir == -1){
            
            for(int i=n-1; i>=0; i--){
                if(chrs[i] == '.') {
                    if(!st.isEmpty() && st.peek()[0] == dir) {
                        arr[i] = st.peek()[1] - i;
                    } else {
                        arr[i] = Integer.MAX_VALUE;
                    }
                }
                
                if(chrs[i] == 'L') {
                    st.push(new int[]{-1, i});
                } else if(chrs[i] == 'R') {
                    st.push(new int[]{1, i});
                }
            }
            
        } else {
            
            for(int i=0; i<n; i++){
                
                if(chrs[i] == '.') {
                    if(!st.isEmpty() && st.peek()[0] == dir) {
                        arr[i] = i - st.peek()[1];
                    } else {
                        arr[i] = Integer.MAX_VALUE;
                    }
                }
                
                if(chrs[i] == 'L') {
                    st.push(new int[]{-1, i});
                } else if(chrs[i] == 'R') {
                    st.push(new int[]{1, i});
                }
            }
            
        }
    }
    
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] right = new int[n];
        int[] left = new int[n];
        
        // Arrays.fill(right, Integer.MAX_VALUE);
        // Arrays.fill(left, Integer.MAX_VALUE);
        
        char[] chrs = dominoes.toCharArray();
        fillArray(chrs, right, 1);
        fillArray(chrs, left, -1);
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        
        for(int i=0; i<n; i++){
            
            if(left[i] == right[i] && left[i] != 0){
                chrs[i] = '.';
            } else if(left[i] < right[i]) {
                chrs[i] = 'L';
            } else if(left[i] > right[i]) {
                chrs[i] = 'R';
            }
        }
        
        return new String(chrs);
    }
}