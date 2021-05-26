class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int n2 = st.pop();
                int n1 = st.pop();
                if (token.equals("+")){
                    st.push(n1 + n2);
                }
                else if (token.equals("-")){
                    st.push(n1 - n2);
                }
                else if (token.equals("*")){
                    st.push(n1 * n2);
                }
                else if (token.equals("/")){
                    st.push(n1 / n2);
                }
            }
            else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}