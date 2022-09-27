class TimeMap {
    
    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> curr = map.getOrDefault(key, new TreeMap<>());
        curr.put(timestamp, value);
        map.put(key, curr);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> curr = map.getOrDefault(key, new TreeMap<>());
        Integer prev = curr.floorKey(timestamp);
        if(prev != null){
            return curr.get(prev);
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */