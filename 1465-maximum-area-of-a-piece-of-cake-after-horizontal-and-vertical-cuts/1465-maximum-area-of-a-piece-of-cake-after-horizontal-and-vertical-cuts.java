class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        List<Integer> hList = new ArrayList<>();
        hList.add(0); hList.add(h);
        for(int num: horizontalCuts)
            hList.add(num);
        List<Integer> vList = new ArrayList<>();
        vList.add(0); vList.add(w);
        for(int num: verticalCuts)
            vList.add(num);
        
        Collections.sort(hList);
        Collections.sort(vList);
        
        int maxHDiff = 0, maxVDiff = 0;
        for(int i=1;i<hList.size();i++){
            maxHDiff = Math.max(maxHDiff, hList.get(i)-hList.get(i-1));
        }
        
        for(int i=1;i<vList.size();i++){
            maxVDiff = Math.max(maxVDiff, vList.get(i)-vList.get(i-1));
        }
        
        long mod = (long) 1e9 + 7;
        long ans1 = maxHDiff % mod;
        long ans2 = maxVDiff % mod;
        long ans = (ans1 * ans2)%mod;
        return (int) ans;
    }
}