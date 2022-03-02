class Solution {
    
    public String constructNum(Stack<Integer> st){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
            
        }
        return removeStartZero(sb.reverse().toString());
    }
    
    public String removeStartZero(String num){
        boolean start = false;
        int i = 0;
        while(!start && i<num.length() && num.charAt(i) == '0'){
            i++;
        }
        
        String result = num.substring(i);
        return result.length() == 0 ? "0" : result;
    }
    
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        if(k == num.length())
            return "0";
        int i = 0, n = num.length();
        while(i < n){
            char ch = num.charAt(i);
            int val = ch  - '0';
            while(k > 0 && !st.isEmpty() && st.peek() > val){
                st.pop();
                k--;
            }
            st.add(val);
            i++;
        }
        
        while(k > 0){
            st.pop();
            k--;
        }
        
        return constructNum(st);
    }
}