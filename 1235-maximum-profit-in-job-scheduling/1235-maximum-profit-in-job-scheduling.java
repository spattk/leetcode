class Solution {
    //stores the max profit when we start at index i
    Integer[] memo;
    Integer[] starts;
    int n;
    
    public int getNextNonConflictingJob(List<int[]> jobs, int idx){
        int newIdx = jobs.size();
        int low = 0, high = jobs.size() - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(jobs.get(mid)[0] >= jobs.get(idx)[1]){
                newIdx = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return newIdx;
    }
    
    public int maxProfitUtil(List<int[]> jobs, int idx){
        if(idx == n)
            return 0;
        
        if(memo[idx] != null)
            return memo[idx];
        
        int nextNonConflictingIdx = getNextNonConflictingJob(jobs, idx);
        
        //take the current one or skip
        int result =  Math.max(
            jobs.get(idx)[2] + maxProfitUtil(jobs, nextNonConflictingIdx),
            maxProfitUtil(jobs, idx+1)
        );
        
        return memo[idx] = result;
    }
    
    public void fillStartTime(List<int[]> jobs ){
        int i=0;
        for(int [] j: jobs){
            starts[i++] = j[0];
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        n = profit.length;
        memo = new Integer[n];
        starts = new Integer[n];
        
        for(int i=0; i<n; i++){
            int[] j = new int[]{startTime[i], endTime[i], profit[i]};
            jobs.add(j);
        }
        
        jobs.sort((a,b)->a[0]-b[0]);
        fillStartTime(jobs);
        
        return maxProfitUtil(jobs, 0);
    }
}