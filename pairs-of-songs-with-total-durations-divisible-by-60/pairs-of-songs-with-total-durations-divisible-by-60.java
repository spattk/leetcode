class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<1000;i+=60){
            list.add(i);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int t: time){
            for(int i=0;i<list.size();i++){
                if(map.get(list.get(i)-t) != null){
                    count += map.get(list.get(i)-t);
                }
            }
            map.put(t, map.getOrDefault(t,0)+1);
        }
        
        return count;
    }
}