class Solution {
	class TrieNode {
		TrieNode[] children;
		String word;

		TrieNode(){
			children = new TrieNode[26];
			word = null;
		}
	}

	public void addWord(TrieNode root, String word){
		TrieNode curr = root;
		for(char ch: word.toCharArray()){
			if(curr.children[ch-'a'] == null){
				curr.children[ch-'a'] = new TrieNode();
			}
			curr = curr.children[ch-'a'];
		}
		curr.word = word;
	}
	
	Map<Integer, String> map;
	String maxWord = "";
	TrieNode root;
	
	public void dfs(TrieNode curr, int idx){
		if(curr == null || curr.word == null)
			return;
			
		if(map.get(idx) == null || map.get(idx).length() < curr.word.length()){
			map.put(idx, curr.word);
			if(maxWord.equals("") || curr.word.length() > maxWord.length()){
				maxWord = curr.word;
			}
		}

		for(int i=0; i<26; i++){
			dfs(curr.children[i], idx);
		}
	}

    	public String longestWord(String[] words) {
     		map = new HashMap<>();
		root = new TrieNode();

		for(String word: words){
			addWord(root, word);
		}
		
		for(int i=0; i<26; i++){
			dfs(root.children[i], i);
		}

		return maxWord;
    	}
}
