

class Solution {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }

        public void addWord(String word){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.children.get(ch) == null){
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            
            curr.isWord = true;
        }
    }
    
    Set<String> answer = new HashSet<>();
    int[][]dx = {{-1, 0}, {1,0}, {0, 1}, {0, -1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    public void dfs(int x, int y, StringBuilder sb, TrieNode node, char[][] board, boolean[][]visited) {
        
        char ch = sb.charAt(sb.length()-1);
        if(node.children.get(ch) == null){
            return;
        }
        
        node = node.children.get(ch);
        if(node.isWord)
            answer.add(sb.toString());
        
        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            
            if(isSafe(nx, ny, board.length, board[0].length) && !visited[nx][ny]){
                sb.append(board[nx][ny]);
                visited[nx][ny] = true;
                dfs(nx, ny, sb, node, board, visited);
                visited[nx][ny] = false;
                sb.setLength(sb.length()-1);
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
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<r; i++){
            for(int j=0; j<c; j++){
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb, root, board, visited);
                sb.setLength(sb.length()-1);
                visited[i][j] = false;
            }
        }
        
        return new ArrayList<>(answer);
    }
}