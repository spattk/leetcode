class RangeModule {

    TreeMap<Integer, Integer> range;
    public RangeModule() {
        range = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer fk = range.floorKey(left);
        if(fk != null){
            if(range.get(fk) >= left){
                left = Math.min(left, fk);
                right = Math.max(right, range.get(fk));
                range.remove(fk);
            }
        }
        
        range.put(left, right);
        
        Integer ck = range.higherKey(left);
        while(ck != null && ck <= right){
            right = Math.max(right, range.get(ck));
            range.remove(ck);
            range.put(left, right);
            ck = range.higherKey(left);
        }
    }
    
    public boolean queryRange(int left, int right) {
        Integer fk = range.floorKey(left);
        return fk != null && range.get(fk)>=right;
    }
    
    public void removeRange(int left, int right) {
        addRange(left, right);
        Integer fk = range.floorKey(left);
        int l1 = fk, r2 = range.get(fk);
        int r1 = left, l2 = right;
        
        range.remove(fk);
        if(l1 < r1)
            range.put(l1, r1);
        
        if(l2 < r2){
            range.put(l2, r2);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */