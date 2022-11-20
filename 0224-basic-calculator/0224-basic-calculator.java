class Solution {
    public int calculate(String s) {
        int res = 0, curr = 0, sign = 1;
        
        Stack<Integer> st = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                curr = curr * 10 + (ch - '0');    
            }   
            else if(ch == '+' || ch == '-') {
                res += sign * curr;
                
                if(ch == '+') sign = 1;
                else sign = -1;
                
                curr = 0;
            }
            else if (ch == '(') {
                st.push(res);
                st.push(sign);
                
                res = 0;
                sign = 1;
            }
            else if (ch == ')') {
                res += sign * curr;
                
                res *= st.pop();
                res += st.pop();
                
                curr = 0;
            }
        }
        
        return res + sign  * curr;
    }
}