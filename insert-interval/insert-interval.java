class Solution {
    
    public int[][] convert(List<int[]> iList){
        int n = iList.size();
        int[][] result = new int[n][2];
        for(int i=0;i<n;i++){
            result[i] = iList.get(i);
        }
        return result;
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> iList = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        for(int i=0;i<n;i++){
            iList.add(intervals[i]);
        }
        int k = 0;
        //if there are list which are lesser than
        while(k < n && iList.get(k)[1] < newInterval[0]) {
            result.add(new int[]{iList.get(k)[0], iList.get(k)[1]});
            k++;
        }
        
        //overlapping
        int start = newInterval[0];
        int end = newInterval[1];
        while(k < n && iList.get(k)[0] <= newInterval[1]) {
            start = Math.min(start, iList.get(k)[0]);
            end = Math.max(end, iList.get(k)[1]);
            k++;
        }
        result.add(new int[]{start, end});
        
        //end
        while(k < n){
            result.add(new int[]{iList.get(k)[0], iList.get(k)[1]});
            k++;
        }
        
        return convert(result);
    }
}