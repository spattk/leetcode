class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        int prev = lower;
        int curr;
        int n = nums.length;
        
        if(n == 0){
            String temp;
            if(lower == upper){
                temp = "" + lower;
                result.add(temp);
            } else {
                temp = "" + lower + "->" + upper;
                result.add(temp);
            }
            return result;
        }
        
        for(int i=0;i<n;i++){
            
            curr = nums[i];
            
            int diff = curr - prev;
            // System.out.println("-- " + i + " p " + prev + " c " + curr + " d " + diff);
            if(diff  <= 0) {
                //nothing
            } else if (diff == 1){
                String num = "" + prev;
                result.add(num);
            } else if(diff > 1){
                int modPrev = prev;
                int modCurr = curr-1;
                
                String num = (modPrev) + "->" + (modCurr);
                result.add(num);
            }
            
            prev = curr+1;
        }
        
        String temp;
        if(upper - prev == 0){
            temp = "" + prev;
            result.add(temp);
        } else if(upper - prev >= 1){
            temp = "" + prev + "->" + upper;
            result.add(temp);
        }
        
        return result;
    }
}