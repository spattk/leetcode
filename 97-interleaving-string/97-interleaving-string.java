class Solution {
    
    Map<String, Boolean> map = new HashMap<>();
    public boolean solve(String s1, String s2, String s3, int i, int j, int k){
        if(i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        
        if(i >= s1.length() && j >= s2.length() && k < s3.length())
            return false;
        
        if(k >= s3.length())
            return false;
        
        String key = "" + i + "," + j + "," + k;
        boolean res = false;
        if(map.get(key)!=null)
            return map.get(key);
        
        if(i >= s1.length()){
            res = s2.charAt(j) == s3.charAt(k) && solve(s1, s2, s3, i, j+1, k+1);
            map.put(key, res);
            return res;
        }
        
        if(j >= s2.length()){
            res = s1.charAt(i) == s3.charAt(k) && solve(s1, s2, s3, i+1, j, k+1);
            map.put(key, res);
            return res;
        }
        
        if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            res = solve(s1, s2, s3, i+1, j, k+1) || solve(s1, s2, s3, i, j+1, k+1);
            map.put(key, res);
            return res;
        } else if(s1.charAt(i) == s3.charAt(k)){
            res = solve(s1, s2, s3, i+1, j, k+1);
            map.put(key, res);
            return res;
        } else if(s2.charAt(j) == s3.charAt(k)){
            res =  solve(s1, s2, s3, i, j+1, k+1);
            map.put(key, res);
            return res;
        }
        
        map.put(key, false);
        return false;
        
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        return solve(s1, s2, s3, 0,0,0);
    }
}