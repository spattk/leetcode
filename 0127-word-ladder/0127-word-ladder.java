class Solution {
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        
        int level = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            level++;
            for(int i=0; i< size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return level;
                }
                char[] chars = curr.toCharArray();
                char prev;
                for(int pos=0; pos< chars.length; pos++){
                    for(int idx= 0; idx<26;idx++){
                        prev = chars[pos];
                        chars[pos] = (char) ('a' + idx);
                        String word = new String(chars);
                        if(words.contains(word) && !visited.contains(word)){
                            visited.add(word);
                            q.add(new String(chars));
                        }
                        chars[pos] = prev;
                    }
                }
            }
            
        }
        
        return 0;
    }
}