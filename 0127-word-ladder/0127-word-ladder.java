class Solution {
    
    int minLevel = 0;
    
//     public boolean isAdj(String s1, String s2){
//         if(s1.length() != s2.length())
//             return false;
        
//         int count = 0;
//         int n = s1.length();
//         for(int i=0; i<n; i++){
//             if(s1.charAt(i) != s2.charAt(i)){
//                 count++;
                
//                 if(count > 1)
//                     return false;
//             }
//         }
        
//         return count == 1;
//     }
    
//     public void createAdjList(Map<String, Set<String>> adj, String beginWord, List<String> wordList) {
//         int n = wordList.size();
//         for(int i=0; i< n; i++){
//             for(int j=0; j< n; j++){
//                 if(i == j)
//                     continue;
                
//                 if(isAdj(wordList.get(i), wordList.get(j))){
//                     Set<String> set = adj.getOrDefault(wordList.get(i), new HashSet<>());
//                     set.add(wordList.get(j));
//                     adj.put(wordList.get(i), set);
//                 }
//             }
//         }
        
//         if(adj.get(beginWord) == null){
//             for(int i=0;i<n;i++){
//                 if(isAdj(wordList.get(i), beginWord)){
//                     Set<String> set = adj.getOrDefault(beginWord, new HashSet<>());
//                     set.add(wordList.get(i));
//                     adj.put(beginWord, set);
//                 }
//             }
//         }
//     }
    
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
                    minLevel = level;
                    return minLevel;
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