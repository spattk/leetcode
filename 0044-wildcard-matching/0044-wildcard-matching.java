class Solution {
    
        Map<Pair<Integer, Integer>, Boolean> map;
        
        public boolean restAllStars(char[] p, int j){
            for(int i=j; i<p.length; i++){
                if(p[i]!='*')
                    return false;
            }
            
            return true;
        }
    
    	public boolean util(char [] s, char [] p, int i, int j){
            Pair pair = new Pair(i, j);
            boolean result = false;
        	if(i >= s.length && j>= p.length){
                result= true;
                map.put(pair, result);
                return result;
            }
            	
        
        	if(j >= p.length){
                result= false;
                map.put(pair, result);
                return result;
            }
			
            
            if(i >= s.length && restAllStars(p, j)){
                result= true;
                map.put(pair, result);
                return result;
            }
                
            
            if(i >=s.length){
                result= false;
                map.put(pair, result);
                return result;
            }
            
            if(map.get(pair) != null)
                return map.get(pair);

		
            if(s[i] == p[j] || p[j] == '?'){
                result= util(s, p, i+1, j+1);
                map.put(pair, result);
                return result;
            }

            if(p[j] == '*'){
                result= util(s, p, i+1, j) || util(s, p, i, j+1);
                map.put(pair, result);
                return result;
            }

            result = false;
            map.put(pair, result);
            return result;
	
    	}
    
    	public boolean isMatch(String s, String p) {
            map = new HashMap<>();
     		return util(s.toCharArray(), p.toCharArray(), 0, 0);  
    	}
}


