class Solution {
    boolean[][] visited;
    int[][] dx = {{-1,0}, {1,0}, {0, 1}, {0, -1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    Set<String> result = new HashSet<>();
    public void findWordUtil(char[][] board, int x, int y, StringBuilder sb, Set<String> words, Set<String> orig) {
        
        String str = sb.toString();
        
        if(!words.contains(str)){
            return;
        }
        
        if(orig.contains(str))
            result.add(str);
        
        
        
        for(int i =0 ;i <dx.length; i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            
            if(isSafe(nx, ny, board.length, board[0].length) && !visited[nx][ny]){
                sb.append(board[nx][ny]);
                visited[nx][ny] = true;
                findWordUtil(board, nx, ny, sb, words, orig);
                visited[nx][ny] = false;
                sb.setLength(sb.length()-1);
            }
        }
        
    }
   
    public List<String> findWords(char[][] board, String[] words) {
        StringBuilder sb = new StringBuilder();
        int r = board.length;
        int c = board[0].length;
        visited = new boolean[r][c];
        Set<String> wordSet = new HashSet<>();
        for(String word: words){
            StringBuilder sb1 = new StringBuilder();
            for(char ch: word.toCharArray()){
                sb1.append(ch);
                wordSet.add(sb1.toString());
            }
        }
        
        Set<String> orig = new HashSet<>(Arrays.asList(words));
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                visited[i][j] = true;
                sb.append(board[i][j]);
                findWordUtil(board, i, j, sb, wordSet, orig);
                visited[i][j] = false;
                sb.setLength(sb.length()-1);
            }
        }
        
        return new ArrayList<>(result);
    }
}