class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a1, a2)-> {
            int res = Integer.compare(a1[0], a2[0]);
            if(res != 0)
                return res;

            return Integer.compare(a1[1], a2[1]);
        });
        
        int n = people.length;
        int[][] ans = new int[n][2];
        for(int i=0; i<n; i++){
            ans[i][0] = -1;
            ans[i][1] = -1;
        }
        
        for(int[] p: people){
            int count = p[1];
            for(int i=0; i<n; i++){
                if(ans[i][0] != -1){
                    if(ans[i][0] >= p[0])
                        count--;
                } else {
                    if(count == 0){
                        ans[i] = p;
                        break;
                    } else {
                        count--;
                    }
                }
            }
        }
        
        return ans;
    }
}