class MyCalendar {

    TreeMap<Integer, Integer> tmap;
    public MyCalendar() {
        tmap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer lowerKey = tmap.floorKey(start);
        if (lowerKey!= null){
            if (tmap.get(lowerKey) > start){
                return false;
            }
        }
        
        Integer higherKey = tmap.ceilingKey(start);
        if (higherKey != null){
            if(end > higherKey){
                return false;
            }
        }
        
        tmap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */