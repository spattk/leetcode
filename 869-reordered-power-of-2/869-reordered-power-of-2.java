class Solution {
    
    public boolean matches(int[] arr, int[] brr){
    
        for(int i=0; i<10;i++)
            if(arr[i] != brr[i])
                return false;
        
        
        return true;
        
    }
    
    public int[] getMap(String s){
        int[] map = new int[10];
        for(char ch: s.toCharArray())
            map[ch-'0']++;
        
        return map;
    }
    
    Set<String> powerOf2 = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        for(int i=0; i<31;i++){
            powerOf2.add(new String("" + (int)Math.pow(2, i)));
        }
        
        String num = "" + n;
        int[] map = getMap(num);
        for(String str: powerOf2){
            if(matches(map, getMap(str)))
                return true;
        }
        
        return false;
    }
}