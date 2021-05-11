class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int n = boxes.length();
        int count;
        for(int i=0;i<n;i++){
            count = 0;
            for(int j=0;j<n;j++){
                if (boxes.charAt(j)=='1'){
                    count += Math.abs(j-i);
                }
            }
            result[i] = count;
        }
        return result;
    }
}