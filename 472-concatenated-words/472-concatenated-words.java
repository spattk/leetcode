class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(String word: words) {
            set.add(word);
        }
        
        
        for(String word: words){
            if(isConcat(word, set)){
                list.add(word);
            }
        }
        
        
        return list;
    }
    
    public boolean isConcat(String word, Set<String> set){
        for(int i=1; i<word.length(); i++){
            String suffix = word.substring(i);
            String prefix = word.substring(0, i);
            if(set.contains(prefix) && (set.contains(suffix) || isConcat(suffix, set)))
               return true;
        }
               
    
        return false;
    }

    
}