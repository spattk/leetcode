class MyCalendar {

    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        boolean collision = false;
        for(int[] ele: list){
            
            if((start <= ele[0] && end > ele[0]) || (start >= ele[0] && end <= ele[1]) || (start >= ele[0] && start < ele[1] && end > ele[1])){
                collision = true;
                break;
            }
        }
        
        if(collision)
            return false;
        list.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */