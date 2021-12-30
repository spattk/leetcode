class Solution {
    
    class Node {
        int c;
        String word;
        
        Node(int c, String word){
            this.c = c;
            this.word = word;
        }
    }
    
    //to store the mappings
    Map<String, Set<String>> map = new HashMap<>();
    
    public boolean isTransformation(String w1, String w2){
        int diff = 0;
        int n1 = w1.length(), n2 = w2.length();
        if(n1 != n2){
            return false;
        }
        
        for(int i=0;i<n1;i++){
            if(w1.charAt(i) != w2.charAt(i)){
                diff++;
            }
            
            if(diff > 1)
                return false;
        }
        
        return true;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        
        for(int i=0;i<n;i++){
            String word = wordList.get(i);
            Set<String> currList = map.getOrDefault(word, new HashSet<>());
            for(int j=0;j<n;j++){
                if(i == j)
                    continue;
                
                if(isTransformation(wordList.get(i), wordList.get(j))){
                    currList.add(wordList.get(j));
                }
            }
            
            map.put(word, currList);
        }
        
        
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new Node(1, beginWord));
        visited.add(beginWord);
        int count = 0;
        // System.out.println(map);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.word.equals(endWord))
                return temp.c;
            for(String w: map.get(temp.word)){
                if(!visited.contains(w)){
                    q.add(new Node(temp.c+1, w));
                    visited.add(temp.word);
                }
            }
        }
        
        
        return 0;
    }
}