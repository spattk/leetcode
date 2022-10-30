

class Solution {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        String word;

        TrieNode(){
            children = new HashMap<>();
            word = null;
        }

        public void addWord(String word){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.children.get(ch) == null){
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            
            curr.word = word;
        }
    }
    
    Set<String> answer = new HashSet<>();
    int[][]dx = {{-1, 0}, {1,0}, {0, 1}, {0, -1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    public void dfs(int x, int y, TrieNode node, char[][] board, boolean[][]visited) {
        
        char ch = board[x][y];
        if(node.children.get(ch) == null){
            return;
        }
        
        node = node.children.get(ch);
        if(node.word != null)
            answer.add(node.word);
        
        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            
            if(isSafe(nx, ny, board.length, board[0].length) && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, node, board, visited);
                visited[nx][ny] = false;
            }
        }
    }
    
    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        
        for(String word: words){
            root.addWord(word);
        }
        
        int r = board.length, c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for(int i =0; i<r; i++){
            for(int j=0; j<c; j++){
                visited[i][j] = true;
                dfs(i, j, root, board, visited);
                visited[i][j] = false;
            }
        }
        
        return new ArrayList<>(answer);
    }
}