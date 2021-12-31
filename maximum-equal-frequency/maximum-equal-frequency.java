class Solution {
    public int maxEqualFreq(int[] nums) {
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(count.get(num)!=null){
                int curr = count.get(num);
                if(freq.getOrDefault(curr,0) == 1){
                    freq.remove(curr);
                    
                } else {
                    freq.put(curr, freq.get(curr)-1);
                }
                freq.put(curr+1, freq.getOrDefault(curr+1,0) + 1);
                count.put(num, count.get(num)+1);
            } else {
                count.put(num, 1);
                freq.put(1, freq.getOrDefault(1,0)+1);
            }
            
            if(freq.size() == 1){
                Set<Integer> set = freq.keySet();
                for(int temp: set){
                    if(temp == 1 || freq.get(temp) == 1){
                        max = i+1;
                    }
                }
            } else if(freq.size() == 2){
                Set<Integer> set = freq.keySet();
                Integer fk = null, fv = null, sk = null, sv = null;
                for(int temp: set){
                    if(fk == null){
                        fk = temp;
                        fv = freq.get(temp);
                    } else {
                        sk = temp;
                        sv = freq.get(temp);
                    }
                }
                
                if(fv == 1 && (fk == 1 || fk == sk + 1)){
                    max = i+1;
                }
                else if (sv == 1 && (sk == 1 || sk == fk + 1)){
                    max = i+1;
                }
                  
            }
        } 
        
        return max;
    }
}