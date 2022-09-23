class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        final int MOD = 1000000007;
        int res  = 0;
        for(int i=1; i<=n; i++){
            String bin = Integer.toBinaryString(i);
            for(int j = 0 ; j<bin.length() ; j++){
                res = (res * 2 + (bin.charAt(j) - '0')) % MOD;
            }
        }
        
        
        return (res);
    }
}