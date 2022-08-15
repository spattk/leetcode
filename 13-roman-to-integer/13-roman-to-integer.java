class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        s = new StringBuilder(s).reverse().toString();
        int prev = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            int val = map.get(ch);
            if(val >= prev){
                result += val;
            } else {
                result -= val;
            }
            
            prev = val;
        }
        
        return result;
    }
}