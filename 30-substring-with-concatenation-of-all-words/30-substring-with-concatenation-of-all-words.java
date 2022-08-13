class Solution {
    
    public void getWordMap(Map<String, Integer> wordMap, String[] words){
        for(String word: words){
            wordMap.put(word, wordMap.getOrDefault(word,0)+1);
        }
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int l = words[0].length();
        int wn = words.length;
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<l; i++){
            Map<String, Integer> wordMap = new HashMap<>();
            getWordMap(wordMap, words);
            int matchCount = 0;
            for(int j=i; j<n; j+=l){
                
                if(j + l > n)
                    break;
                
                if(j == i){
                    for(int k=0; k<wn; k++){
                        
                        if(j + k*l + l > n)
                            break;
                        
                        String sub = s.substring(j + k*l, j + k*l + l);
                        // System.out.println("::" + sub);
                        if(wordMap.get(sub) != null){
                            wordMap.put(sub, wordMap.get(sub)-1);
                            
                            if(wordMap.get(sub) == 0){
                                matchCount++;
                            } else if(wordMap.get(sub) == -1) {
                                matchCount--;
                            }
                        }
                    }
                    
                    if(matchCount == wordMap.size())
                        answer.add(j);
                } else {
                    //sliding window
                    String last = s.substring(j - l, j);
                    if(j + (wn-1) * l + l > n)
                        break;
                    String next = s.substring(j + (wn-1) * l, j + (wn-1) * l + l);
                    
                    // System.out.println(last + "::" + next);
                    
                    if(wordMap.get(last) != null){
                        wordMap.put(last, wordMap.get(last)+1);
                        if(wordMap.get(last) == 0){
                            matchCount++;
                        } else if(wordMap.get(last) == 1) {
                            matchCount--;
                        }
                    }
                    
                    if(wordMap.get(next) != null){
                        wordMap.put(next, wordMap.get(next)-1);
                        if(wordMap.get(next) == 0){
                            matchCount++;
                        } else if(wordMap.get(next) == -1) {
                            matchCount--;
                        }
                    }
                    
                    if(matchCount == wordMap.size())
                        answer.add(j);
                }
                
            }
        }
        
        return answer;
    }
}