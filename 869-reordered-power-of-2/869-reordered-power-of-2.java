class Solution {
    
    public boolean matches(int[] arr, int[] brr){
    
        for(int i=0; i<10;i++)
            if(arr[i] != brr[i])
                return false;
        
        
        return true;
        
    }
    
    public int[] getMap(int n){
        int[] map = new int[10];
        while(n>0){
            map[n%10]++;
            n/=10;
        }
        
        return map;
    }
    
    Set<Integer> powerOf2 = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        for(int i=0; i<31;i++){
            powerOf2.add((int)Math.pow(2, i));
        }
        
        int[] map = getMap(n);
        for(Integer str: powerOf2){
            if(matches(map, getMap(str)))
                return true;
        }
        
        return false;
    }
}