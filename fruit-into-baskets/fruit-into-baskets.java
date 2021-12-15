class Solution {
    public int totalFruit(int[] fruits) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int fruit: fruits){
            q.add(fruit);
            if(map.get(fruit) == null){
                if(map.size() < 2){
                    count ++;
                    map.put(fruit, map.getOrDefault(fruit, 0) + 1);
                } else{
                    max = Math.max(max, count);
                    
                    int ele = q.peek();
                    int k = map.get(ele);
                    
                    while(true){
                        int temp = q.poll();
                        if(temp == ele){
                            k--;
                        }
                        count--;
                        map.put(temp, map.getOrDefault(temp,0)-1);
                        if(map.get(temp) == 0){
                            map.remove(temp);
                            break;
                        }
                        
                        if(k == 0)
                            break;
                    }
                    
                    //for the new one
                    count++;
                    map.put(fruit, map.getOrDefault(fruit, 0) + 1);
                }
            } else {
                count++;
                map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            }
        }
        max = Math.max(max, count);
        return max;
    }
}