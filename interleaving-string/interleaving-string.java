class Solution {
    
    //recursive function
    int l1, l2,l3;
    HashMap<String, Boolean> map;
    Boolean sol = false;
    
    private String getKey(int p1, int p2, int p3){
        String key = "" + p1 + "|" + p2 + "|" + p3;
        return key;
    }
    
    public boolean match(String s1, String s2, String s3, int p1, int p2, int p3) {
        if (p3 == l3){
            return (p1 == l1 && p2 == l2)?true: false;
        }
        
        String key = getKey(p1, p2, p3);
        if (map.get(key) != null){
            return map.get(key);
        }
        //p1 is over
        if (p1 == l1){
            if (s2.charAt(p2) == s3.charAt(p3)){
                key = getKey(p1, p2+1, p3+1);
                sol = match(s1, s2, s3, p1, p2+1, p3+1);
                
            } else {
                sol = false;
            }
            map.put(key, sol);
            return sol;
        }
        
        else if (p2 == l2){
            if (s1.charAt(p1) == s3.charAt(p3)){
                key = getKey(p1+1, p2, p3+1);
                sol= match(s1, s2, s3, p1+1, p2, p3+1);
            } else {
                sol = false;
            }
            map.put(key, sol);
            return sol;
        }
        
        else {
            boolean v1 = false, v2= false;
            if (s1.charAt(p1)==s3.charAt(p3)){
                v1 = match(s1, s2, s3, p1+1, p2, p3+1);
            }
            
            if (s2.charAt(p2) == s3.charAt(p3)){
                v2 = match(s1, s2, s3, p1, p2+1, p3+1);
            }
            
            map.put(key, v1 || v2);
            return v1 || v2;
        }
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        map = new HashMap<>();
        
        
        if (l1 + l2 != l3){
            return false;
        }
        
        int p1=0,p2=0,p3=0;
        return match(s1, s2, s3, p1, p2, p3);
    }
}