class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
        
        void addWord(String word, TrieNode root){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                
                curr = curr.children[ch-'a'];
            }
            
            curr.isWord = true;
        }
        
        void dfs(TrieNode curr, List<String> currList, List<Character> path){
            if(currList.size() == 3){
                return;
            }
            
            if(curr.isWord){
                StringBuilder sb = new StringBuilder();
                for(char ch: path)
                    sb.append(ch);
                currList.add(sb.toString());
            }
            
            for(int i=0; i<26; i++){
                if(curr.children[i] != null){
                    path.add((char)('a'+i));
                    dfs(curr.children[i], currList, path);
                    path.remove(path.size()-1);
                    
                }
            }
        }
        
        List<String> search(String word, TrieNode root, List<String> currList){
            TrieNode curr = root;
            List<Character> path = new ArrayList<>();
            for(char ch: word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    return new ArrayList<>();
                }
                
                curr = curr.children[ch-'a'];
                path.add(ch);
            }
            
            dfs(curr, currList, path);
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