class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.get(val) != null){
            return false;
        }
        
        int pos = list.size();
        map.put(val, pos);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.get(val) == null)
            return false;
        
        int pos = map.get(val);
        int lastPos = list.size()-1;
        
        
        //swap
        map.put(list.get(lastPos), pos);
        
        //swap in list
        list.set(pos, list.get(lastPos));
        
        // System.out.println(map);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */