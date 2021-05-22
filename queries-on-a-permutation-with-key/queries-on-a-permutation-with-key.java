class Solution {
    public int[] processQueries(int[] queries, int m) {
        ArrayList<Integer> p = new ArrayList<>();
        for(int i=1;i<=m;i++){
            p.add(i);
        }
        
        int n = queries.length;
        
        int [] result = new int[n];
        for(int i=0;i<n;i++){
            int temp = queries[i];
            int idx = p.indexOf(temp);
            result[i] = idx;
            p.remove(new Integer(temp));
            p.add(0, temp);
        }
        
        return result;
    }
}