class Solution {
    
    Map<Pair<Integer, Integer>, Boolean> map = new HashMap<>();
    public boolean isMatchUtil(String s, String p, int i, int j){
        Pair<Integer, Integer> pair = new Pair(i, j);
        if(map.get(pair) != null)
            return map.get(pair);
            
        boolean result = false;
        if(i >= s.length() && j >= p.length()){
            result = true;
            map.put(pair, result);
            return result;
        }
        
        if(j >= p.length()){
            result = false;
            map.put(pair, result);
            return result;
        }
        
        boolean match = i < s.length() && ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        
        if((j+1) < p.length() && p.charAt(j+1) == '*'){
            //ignore it or take it
            result= isMatchUtil(s,p,i,j+2) || match && isMatchUtil(s,p,i+1,j);
            map.put(pair, result);
            return result;
        }
        
        if(match){
            result =  isMatchUtil(s,p,i+1, j+1);
            map.put(pair, result);
            return result;
            
        }
        result= false;
        map.put(pair, result);
        return result;
    }
    
    public boolean isMatch(String s, String p) {
        return isMatchUtil(s, p, 0, 0);
    }
}