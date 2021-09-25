class Solution {
    Set<String> set;
    HashMap<Integer, Boolean> map;
    public boolean wordBreakUtil(String s, int pos) {
        if (pos >= s.length()){
            return true;
        }
        if(map.get(pos)!=null){
            return map.get(pos);
        }
        
        String t = "";
        for(int i=pos;i<s.length();i++){
            // System.out.println(i + " " + pos);
            if(set.contains(s.substring(pos, i+1)) && wordBreakUtil(s, i+1)){
                boolean temp = true;
                map.put(pos, true);
                return temp;
            }
        }
        
        map.put(pos, false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        map = new HashMap<>();
        for(String str: wordDict){
            set.add(str);
        }
        return wordBreakUtil(s, 0);
    }
}