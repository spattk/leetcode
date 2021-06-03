class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        List<Integer> ho = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        
        ho.add(0);
        for(int num: horizontalCuts){
            ho.add(num);
        }
        ho.add(h);
        
        int mod = 1000000007;
        
        v.add(0);
        for(int num: verticalCuts){
            v.add(num);
        }
        v.add(w);
        
        
        
        Collections.sort(ho);
        Collections.sort(v);
        
        int maxH = 0;
        int maxW = 0;
        
        for(int i=0;i<ho.size()-1;i++){
            maxH = Math.max(maxH, ho.get(i+1)- ho.get(i));
        }
        
        for(int i=0;i<v.size()-1;i++){
            maxW = Math.max(maxW, v.get(i+1)- v.get(i));
        }
        
        return (int)(maxH % (1e9 + 7) * maxW % (1e9 + 7));
    }
}