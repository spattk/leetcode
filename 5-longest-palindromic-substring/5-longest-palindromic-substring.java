class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int start = 0, maxLen = 0;
        
        for(int i=0;i<n;i++){
            int l = i, r = i;
            // odd
            while(l>=0 && r < n && s.charAt(l) == s.charAt(r)){
                if((r-l+1)>maxLen){
                    start = l;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
            
            
            //even
            l = i; r = i+1;
            while(l>=0 && r < n && s.charAt(l) == s.charAt(r)){
                if((r-l+1)>maxLen){
                    start = l;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start+maxLen);
    }
}