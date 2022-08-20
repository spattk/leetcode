class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        for(int num: nums){
            if(counter.get(num) != 0){
                counter.put(num, counter.get(num)-1);
                
                if(end.getOrDefault(num-1, 0) !=0 ){
                    end.put(num-1, end.get(num-1)-1);
                    end.put(num, end.getOrDefault(num, 0) + 1);
                } else if (counter.getOrDefault(num+1, 0) !=0 && counter.getOrDefault(num+2, 0) !=0){
                    counter.put(num + 1, counter.get(num + 1) - 1);
                    counter.put(num + 2, counter.get(num + 2) - 1);
                    end.put(num+2, end.getOrDefault(num+2, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}