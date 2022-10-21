class SummaryRanges {

    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.get(val) != null)
            return;
        
        Integer lk = map.lowerKey(val);
        Integer hk = map.higherKey(val);
        
        if(lk != null && hk != null && (map.get(lk) + 1) == val && (hk - 1) == val) {
            map.put(lk, map.get(hk));
            map.remove(hk);
        } else if(lk != null && (map.get(lk) + 1) >= val) {
            map.put(lk, Math.max(map.get(lk), val));
        } else if(hk != null && hk - 1 == val) {
            map.put(val, map.get(hk));
            map.remove(hk);
        } else {
            map.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for(int a:map.keySet()){
            res.add(new int[]{a,map.get(a)});
        }
        return res.toArray(new int[map.size()][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */