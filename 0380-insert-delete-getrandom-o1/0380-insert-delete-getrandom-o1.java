class RandomizedSet {

    List<Integer> list;
    //val -> index
    Map<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.get(val) != null)
            return false;
        
        int size = list.size();
        map.put(val, size);
        
        list.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(map.get(val) == null)
            return false;
        
        int currPos = map.get(val);
        int lastPos = list.size() - 1;
        
        map.put(list.get(lastPos), currPos);
        map.remove(val);
        
        //swap in list
        list.set(currPos, list.get(lastPos));
        list.remove(list.size()-1);
        
        return true;
    }
    
    public int getRandom() {
        int pos = (int) (Math.random() * list.size());
        return list.get(pos);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */