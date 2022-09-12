class Solution {
    List<String> result = new ArrayList<>();
    
    public void backtrack(String s, int x, Set<String> set, List<String> path){
        if(x == s.length()){
            result.add(String.join(" ", path));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = x; i<s.length(); i++){
            sb.append(s.charAt(i));
            if(set.contains(sb.toString())){
                path.add(sb.toString());
                backtrack(s, i+1, set, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        backtrack(s, 0, set, list);
        return result;
    }
}