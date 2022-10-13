class Solution {
    int n;
    public void generateLeft(char[] chs, long[] left1, long [] left0){
        int l1 = 0, l0 = 0, r1 = 0, r0 =0;
        for(int i=0; i<n; i++){
            left1[i] = l1;
            left0[i] = l0;
            if(chs[i] == '1'){
                l1++;
            } else{
                l0++;
            }
        }
    }
    
    public void generateRight(char[] chs, long[] right1, long [] right0){
        int r1 = 0, r0 =0;
        for(int i=n-1; i>=0; i--){
            right1[i] = r1;
            right0[i] = r0;
            if(chs[i] == '1'){
                r1++;
            } else{
                r0++;
            }
        }
    }
    
    public long generateResult(char[] chs, long[] l1, long[] l0, long[] r1, long []r0){
        long sum = 0;
        
        for(int i=1; i<n-1;i++){
            if(chs[i] == '1'){
                sum += l0[i] * r0[i];
            } else {
                sum += r1[i] * l1[i];
            }
        }
        
        return sum;
    }
    
    public long numberOfWays(String s) {
        n = s.length();
        char [] chs = s.toCharArray();
        long[] left1 = new long[n];
        long[] left0 = new long[n];
        long[] right1 = new long[n];
        long[] right0 = new long[n];
        
        generateLeft(chs, left1, left0);
        generateRight(chs, right1, right0);
        
        return generateResult(chs, left1, left0, right1, right0);
        
        
    }
}