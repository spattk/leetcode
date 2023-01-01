class Solution {
    
    Map<Character, Integer> patternMap;
    Map<String, Integer> sMap;
        
    public boolean compareMap(String pattern, String s){
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            if(patternMap.get(pattern.charAt(i)) != sMap.get(arr[i]))
                return false;
        }
        
        return true;
    }
    
    public boolean wordPattern(String pattern, String s) {
        int i=0, j=0;
        patternMap = new HashMap<>();
        sMap = new HashMap<>();
        
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length)
            return false;
        
        for(char ch: pattern.toCharArray()){
            if(patternMap.get(ch)==null){
                patternMap.put(ch, i);
                i++;
            }
        }
        
        for(String str: s.split(" ")){
            if(sMap.get(str)==null){
                sMap.put(str, j);
                j++;
            }
        }
        
        return compareMap(pattern, s);
    }
}