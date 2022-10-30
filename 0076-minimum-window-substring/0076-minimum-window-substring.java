class Solution {
    
    public String getSubstring(String s, int startIdx, int len) {
        
        if(startIdx == -1)
            return "";
        
        return s.substring(startIdx, startIdx + len);
    }
    
    public void getCharMap(String t, Map<Character, Integer> map){
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
    }
    
    public String minWindow(String s, String t) {
        int i=0, j=0;
        Map<Character, Integer> map = new HashMap<>();
        getCharMap(t, map);
        int count = map.size(), n = s.length();
        int startIdx = -1, len = Integer.MAX_VALUE;
        while(j<n){
            
            char ch = s.charAt(j);
            if(map.get(ch) != null){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0)
                    count--;
            }
            
            while(i<=j && count == 0){
                if(j - i + 1 < len){
                    len = j-i+1;
                    startIdx = i;
                }
                ch = s.charAt(i);
                if(map.get(ch) != null) {
                    map.put(ch, map.get(ch)+1);
                    if(map.get(ch) == 1)
                        count++;
                }
                i++;
            }
            
            j++;
        }
        
        return getSubstring(s, startIdx, len);
        
    }
}