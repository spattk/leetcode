class Solution {
    
    Map<Character, Integer> roman = new HashMap<>();
    
    
    public int computeRoman(Stack<Integer> st) {
        Integer result = 0;
        for(Integer num: st){
            result += num;
        }
        return result;
    }
    
    public int romanToInt(String romanNumber) {
        
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        Stack<Integer> st = new Stack<>();
        Character prev = null;
        for(char ch: romanNumber.toCharArray()){
            if(prev == null){
                st.add(roman.get(ch));
            } else {
                if(roman.get(ch) > roman.get(prev)){
                    int temp = st.pop();
                    st.add(roman.get(ch) - temp);
                } else {
                    st.add(roman.get(ch));
                }
            }
            prev = ch;
        }
        return computeRoman(st);
    }
}