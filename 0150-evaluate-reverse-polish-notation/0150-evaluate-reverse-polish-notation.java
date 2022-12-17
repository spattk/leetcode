class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")){
                int second = st.pop();
                int first = st.pop();
                int result = first + second;
                st.push(result);
            }
            else if(token.equals("-")){
                int second = st.pop();
                int first = st.pop();
                int result = first - second;
                st.push(result);
            }
            else if(token.equals("*")){
                int second = st.pop();
                int first = st.pop();
                int result = first * second;
                st.push(result);
            }
            else if(token.equals("/")){
                int second = st.pop();
                int first = st.pop();
                int result = first / second;
                st.push(result);
            }
            else {
                st.push(Integer.parseInt(token));
            }
        }
        
        return st.pop();
    }
}