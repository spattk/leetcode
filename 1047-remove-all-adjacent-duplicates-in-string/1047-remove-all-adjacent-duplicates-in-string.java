class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if (st.isEmpty()){
                st.push(ch);
            } else {
                if (st.peek() == ch) {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c: st){
            sb.append(c);
        }
        return new String(sb);
    }
}