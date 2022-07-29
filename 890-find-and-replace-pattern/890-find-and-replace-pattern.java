class Solution {
    
    public String generateNumericString(String word){
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> visited = new HashMap<>();
        for(char ch: word.toCharArray()){
            if(visited.get(ch)!=null){
                 sb.append(visited.get(ch));
            } else {
                sb.append(counter);
                visited.put(ch, counter);
                counter++;
            }
        }
        
        return sb.toString();
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String patNum = generateNumericString(pattern);
        List<String> result = new ArrayList<>();
        for(String word: words){
            if(generateNumericString(word).equals(patNum))
                result.add(word);
        }
        
        return result;
    }
}
