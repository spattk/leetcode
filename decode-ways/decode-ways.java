class Solution {

    HashMap<Integer, Integer> map;
    int solve(String s, int i){
        if(i == s.length()){
            return 1;
        } else if (i > s.length()){
            return 0;
        } else if (s.charAt(i) == '0'){
            return 0;
        }
        
        if (map.get(i) != null){
            return map.get(i);
        }
        
        if(s.charAt(i) == '1' || s.charAt(i) == '2' && i+1<s.length() && s.charAt(i+1) <= '6'){
            int temp = solve(s, i+1) + solve(s, i+2);
            map.put(i, temp);
            return temp;
            
        } else{
            int temp = solve(s, i+1);
            map.put(i, temp);
            return temp;
        }
        
    }
    
    public int numDecodings(String s) {
        if (s.length() == 1){
            if (s.charAt(0) == '0'){
                return 0;
            } else{
                return 1;
            }
        } else if (s.length() > 1){
            if (s.charAt(0) == '0'){
                return 0;
            }
        }
        map = new HashMap<>();
        return solve(s, 0);
    }
}