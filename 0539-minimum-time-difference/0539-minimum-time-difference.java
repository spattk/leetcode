class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[1440];
        for(String time: timePoints){
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            
            if(seen[hour * 60 + min])
                return 0;
            seen[hour * 60 + min] = true;
        }
        
        Integer firstTime = null;
        Integer prevTime = null;
        Integer diff = Integer.MAX_VALUE;
        
        for(int i=0; i<1440; i++){
            if(seen[i]){
                if(firstTime == null){
                    firstTime = i;
                    prevTime = i;
                } else {
                    diff = Math.min(diff, Math.min(i-prevTime, 1440 - i + prevTime));
                    prevTime = i;
                }
            }
        }
        
        diff = Math.min(diff, Math.min(prevTime - firstTime, 1440 - prevTime + firstTime));
        
        return diff;
    }
}