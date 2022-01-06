class Solution {
    
    
    Map<Integer, Integer> rank = new HashMap<>();
    Map<Integer, Integer> parent = new HashMap<>();
    
    
    int count ;
    
    public int find(int x){
        if(parent.get(x) != x){
            int up = find(parent.get(x));
            parent.put(x, up);
        }
        return parent.get(x);
    }
    
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px == py)
            return;
        
        count--;
        
        if(rank.get(px)<rank.get(py)){
            parent.put(py, px);
        } else if(rank.get(px)>rank.get(py)){
            parent.put(px, py);
        } else {
            parent.put(px, py);
            rank.put(py, rank.get(py)+1);
        }
    }
    public int removeStones(int[][] stones) {
        for(int[] stone: stones){
            int row = -(stone[0] + 1);
            int col = (stone[1] + 1);
            
            rank.put(row, 0);
            rank.put(col, 0);
            parent.put(row,row);
            parent.put(col, col);
        }
        
        count = parent.size();
        
        for(int[] stone: stones){
            int row = -(stone[0] + 1);
            int col = (stone[1] + 1);
            
            union(row, col);
        }
        
        return stones.length - count;
    }
}