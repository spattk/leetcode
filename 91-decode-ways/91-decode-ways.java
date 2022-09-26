class Solution {
    
    Integer[] dp;
    public int decodeUtil(char[] str, int idx) {
        
        if(idx == str.length || (idx == str.length - 1 && str[idx] != '0')){
            return 1;
        }
        
        if(dp[idx] != null)
            return dp[idx];
        
        
        int result =0;
        if(str[idx] == '1') {
            if(idx == str.length - 1) {
                result =  decodeUtil(str, idx+1);
            } else {
                result =  decodeUtil(str, idx + 1) + decodeUtil(str, idx + 2);
            }
        }
        
        else if(str[idx] == '2') {
            if(idx == str.length - 1 || str[idx+1] >= '7') {
                result = decodeUtil(str, idx+1);
            } else if(str[idx + 1] <= '6') {
                result =  decodeUtil(str, idx + 1) + decodeUtil(str, idx + 2);
            }
        }
        
        else if(str[idx] == '0') {
            result = 0;
        }
        
        else {
            result =  decodeUtil(str, idx+1);
        }
        
        return dp[idx] = result;
    }
    
    public int numDecodings(String s) {
        dp = new Integer[s.length() + 1];
        return decodeUtil(s.toCharArray(), 0);
    }
}