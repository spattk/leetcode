class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(map.get(ch));
            }else {
                if(st.isEmpty())
                    return false;
                
                if(st.pop() != ch)
                    return false;
            }
        }
        
        return st.isEmpty();
    }
}