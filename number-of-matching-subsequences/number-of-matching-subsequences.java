class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<String>> map = new HashMap<>();
        for(String st: words){
            if (map.get(st.charAt(0)) == null) {
                map.put(st.charAt(0), new ArrayList<>());
            }
            List<String> temp = map.get(st.charAt(0));
            temp.add(st);
            map.put(st.charAt(0), temp);
        }
        
        int result = 0;
        for(char ch: s.toCharArray()){
            List<String> temp = map.getOrDefault(ch, new ArrayList<>());
            map.put(ch, new ArrayList<>());
            for(String each: temp){
                if (each.length() == 1){
                    result++;
                } else {
                    String newS = each.substring(1);
                    List<String> t = map.getOrDefault(newS.charAt(0), new ArrayList<>());
                    t.add(newS);
                    map.put(newS.charAt(0), t);
                }
            }
        }
        
        return result;
    }
}