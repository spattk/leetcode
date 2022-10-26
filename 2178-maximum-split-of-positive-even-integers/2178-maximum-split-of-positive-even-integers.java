class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if(finalSum % 2 != 0)
            return result;
        
        long num = 2;
        while(finalSum >= num && finalSum != 2*num ){
            finalSum -= num;
            result.add(num);
            num += 2;
        }
        
        if(finalSum >= num)
            result.add(finalSum);
        else {
            long last = result.remove(result.size()-1);
            last += finalSum;
            result.add(last);
        }
            
        
        return result;
    }
}