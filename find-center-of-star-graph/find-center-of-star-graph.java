class Solution {
    public int findCenter(int[][] edges) {
        int count = 0;
        int center = 0;
        int c1=0, c2=0;
        for(int[] edge: edges){
            if (count == 0){
                c1 = edge[0];
                c2 = edge[1];
            }
            
            else if (count == 1){
                if (edge[0]==c1 || edge[0]==c2)
                    return edge[0];
                return edge[1];
            }
            
            count ++;
        }
        return c1;
    }
}