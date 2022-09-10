class Solution {
    
    public boolean isMatchUtil(String s, String p, int i, int j){
        if(i >= s.length() && j >= p.length()){
            return true;
        }
        
        if(j >= p.length()){
            return false;
        }
        
        boolean match = i < s.length() && ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        
        if((j+1) < p.length() && p.charAt(j+1) == '*'){
            //ignore it or take it
            return isMatchUtil(s,p,i,j+2) || match && isMatchUtil(s,p,i+1,j);
        }
        
        if(match){
            return isMatchUtil(s,p,i+1, j+1);
        }
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        return isMatchUtil(s, p, 0, 0);
    }
}