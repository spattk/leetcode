class Solution {
    public boolean populateAdj(Map<Character, Set<Character>> adj, String w1, String w2){
        int minLen = Math.min(w1.length(), w2.length());
        boolean set = false;
        for(int i=0; i< minLen; i++){
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if(c1 != c2){
                adj.putIfAbsent(c1, new HashSet<>());
                adj.get(c1).add(c2);
                set = true;
                break;
            }
        }
        
        if(!set && w1.length() > w2.length())
            return false;
        
        return true;
    }
    
    StringBuilder sb = new StringBuilder();
    
    public boolean dfs(char ch, Map<Character, Boolean> visited, Map<Character, Set<Character>> adj ){
        if(visited.get(ch)!=null)
            return visited.get(ch);
        
        visited.put(ch, true);
        
        for(char nei: adj.getOrDefault(ch, new HashSet<>())){
            if(dfs(nei, visited, adj))
                return true;
        }
        
        visited.put(ch, false);
        sb.append(ch);
        
        return false;
    }
    
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        for(String word: words) {
            for(char ch: word.toCharArray()){
                adj.put(ch, new HashSet<>());
            }
        }
        
        for(int i=0; i<words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            
            if(!populateAdj(adj, w1, w2))
                return "";
        }
            
        Map<Character, Boolean> visited = new HashMap<>();
        for(char ch: adj.keySet()){
            if(dfs(ch, visited, adj))
                return "";
            
        }
        
        return sb.reverse().toString();
    }
}