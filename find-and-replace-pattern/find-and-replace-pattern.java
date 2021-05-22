class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // pattern conversion to ab
        int pidx = 0;
        List<String> result = new ArrayList<>();
        // String patternTemp;
        int n = pattern.length();
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = pattern.charAt(i);
            if(map.get(ch) != null){
                sb.append(map.get(ch));
            } else{
                char next = (char)(97 + pidx);
                pidx++;
                map.put(ch, next);
                sb.append(next);
            }
        }
        String patternTemp = sb.toString();
        
        
        //each word conversion to ab
        for(String word: words){
            StringBuilder temp = new StringBuilder();
            map = new HashMap<>();
            pidx = 0;
            boolean toAdd = true;
            for (int i=0;i<n;i++){
                char ch = word.charAt(i);
                if(map.get(ch) != null){
                    temp.append(map.get(ch));
                } else{
                    char next = (char)(97 + pidx);
                    pidx++;
                    map.put(ch, next);
                    temp.append(next);
                }
                
                if (temp.charAt(i) != patternTemp.charAt(i)){
                    toAdd = false;
                    break;
                }
            }
            
            if (toAdd){
                result.add(word);
            }
            
        }
        
        return result;
    }
}