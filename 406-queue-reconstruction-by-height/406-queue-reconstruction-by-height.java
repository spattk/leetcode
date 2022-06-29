class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> (a[0] == b[0]? a[1]-b[1]: a[0]-b[0]));
        int n = people.length;
        int[][] res= new int[n][2];
        for(int i=0;i<n;i++){
            res[i][0] = -1;
        }
        
        for(int[] p: people){
            int count = p[1];
            boolean flag = true;
            for(int i=0;i<n;i++){
                if(count <= 0 && res[i][0] == -1){
                    res[i][0] = p[0];
                    res[i][1] = p[1];
                    flag = false;
                    break;
                }
                if(res[i][0] == -1 || res[i][0] >= p[0] )
                    count--;

                
            }
        }
        
        return res;
    }
}