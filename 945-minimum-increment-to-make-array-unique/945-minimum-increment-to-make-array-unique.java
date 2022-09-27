class Solution {
    
    public int sum(int n){
        return n*(n+1)/2;
    }
    
    public int minIncrementForUnique(int[] nums) {
        int[] arr = new int[100001];
        for(int num: nums){
            arr[num]++;
        }
        
        int count =0, extra = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 1) {
                extra = arr[i] - 1;
                count += extra;
                if(i == arr.length -1){
                    break;
                } else {
                    arr[i+1] += extra;
                }
                
            } else {
                extra = 0;
            }
        }
        
        if(extra != 0){
            count += sum(extra-1);
        }
        
        return count;
    }
}