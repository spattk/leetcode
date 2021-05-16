class Solution {
    public int[] minOperations(String boxes) {
        int first = 0, total=0;
        int n = boxes.length();
        int[] curr = new int[n];
        int prev = 0;
        for(int i=0;i<n;i++){
            if (boxes.charAt(i)=='1'){
                first += (i-0);
                total ++;
                curr[i] = 1 + prev;
                prev = curr[i];
            }
            curr[i] = prev;
        }
        int [] result = new int[n];
        for(int num:curr){
            System.out.println(num);
        }
        result[0] = first;
        for(int i=1;i<n;i++){
            int val = boxes.charAt(i) == '1' ? 1: 0;
            if (val == 1){
                result[i] = result[i-1] - (total - curr[i] + 1) + (curr[i]-1);
            }
            else {
                result[i] = result[i-1] - (total - curr[i]) + (curr[i]);
            }
        }
        
        return result;
    }
}