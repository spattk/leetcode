/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(List<Interval> eles: schedule){
            for(Interval ele: eles){
                map.put(ele.start, map.getOrDefault(ele.start, 0) + 1);
                map.put(ele.end, map.getOrDefault(ele.end, 0) - 1);
            }
            
        }
        
        int sum = 0;
        Integer start = null;
        List<Interval> list = new ArrayList<>();
        for(int key: map.keySet()){
            sum += map.get(key);
            
            
            if(sum == 0){
                start = key;
            }
            
            else if(start != null && sum != 0){
                list.add(new Interval(start, key));
                start = null;
            }
            
        }
        
        return list;
    }
}