class Solution {
    
    class TrieNode {
        TrieNode[] children;
        String word;
        
        TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
        
        void addWord(String word, TrieNode root){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                
                curr = curr.children[ch-'a'];
            }
            
            curr.word = word;
        }
        
        void dfs(TrieNode curr, List<String> currList){
            if(currList.size() == 3){
                return;
            }
            
            if(curr.word != null){
                currList.add(curr.word);
            }
            
            for(int i=0; i<26; i++){
                if(curr.children[i] != null){
                    dfs(curr.children[i], currList);
                }
            }
        }
        
        List<String> search(String word, TrieNode root, List<String> currList){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    return new ArrayList<>();
                }
                
                curr = curr.children[ch-'a'];
            }
            
            dfs(curr, currList);
            return currList;
        }
        
        
    }
    
    
    TrieNode root = new TrieNode();
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(String product: products){
            root.addWord(product, root);
        }
        
        List<List<String>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: searchWord.toCharArray()){
            sb.append(ch);
            List<String> currList = new ArrayList<>();
            list.add(root.search(sb.toString(), root, currList));
        }
        
        return list;
    }
}