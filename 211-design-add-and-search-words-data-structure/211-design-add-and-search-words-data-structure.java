class WordDictionary {
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        char ch;
        
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    
    public boolean searchWord(String word){
        
        TrieNode curr = root;
        boolean result = false;
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                result = false;
                break;
            }
            curr = curr.children[ch-'a'];
        }
        
        return curr.isEnd;
    }
    
    public boolean searchDFS(String word, int idx, TrieNode curr){
        // System.out.println(word + ":: " + idx + "::" + curr.ch);
        if(idx == word.length() && curr.isEnd)
            return true;
        
        if(idx == word.length())
            return false;
        
        char ch = word.charAt(idx);
        if(ch == '.'){
            //for all path go ahead
            
            for(int i=0; i<26; i++){
                if(curr.children[i] != null) {
                   if(searchDFS(word, idx+1, curr.children[i]))
                    return true; 
                }
            }
            
            
        } else {
            if(curr.children[ch-'a'] != null){
                return searchDFS(word, idx+1, curr.children[ch-'a']);
            } else
                return false;
        }
        
        return false;
    }
    
    public boolean search(String word) {
        return searchDFS(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */