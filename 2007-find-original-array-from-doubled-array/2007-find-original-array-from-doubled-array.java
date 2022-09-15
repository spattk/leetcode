class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: changed){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int num: changed){
            
            if(num == 0){
                if(map.getOrDefault(num, 0) >= 2){
                    result.add(num);
                    map.put(num, map.get(num)-2);
                } else if(map.getOrDefault(num, 0) == 1) {
                    return new int[]{};
                }
            }
            
            else if(map.getOrDefault(num, 0) != 0){
                if(map.getOrDefault(2 * num, 0) != 0){
                    result.add(num);
                    map.put(num, map.get(num)-1);
                    map.put(num *2, map.get(2*num)-1);
                } else {
                    //double is absent
                    return new int[]{};
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}