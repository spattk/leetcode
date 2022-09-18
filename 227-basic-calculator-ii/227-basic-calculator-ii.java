class Solution {
    public String getNumber(String s, int idx){
        StringBuilder sb = new StringBuilder();
        int i = idx;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
    
    public int solveRest(Stack<Integer>numStack, Stack<Character>opStack) {
        while(numStack.size() != 1){
            int n2 = numStack.pop();
            int n1 = numStack.pop();
            char op = opStack.pop();
            
            if(op == '+'){
                numStack.push(n1 + n2);
            } else if (op == '-') {
                numStack.push(n1 - n2);
            }
        }
        
        return numStack.pop();
    }
    
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        
        int n = s.length();
        for(int i=0; i<n; ){
            char ch = s.charAt(i);
            if(ch == ' '){
                i++;
            }
            
            else if(Character.isDigit(ch)){
                String num = getNumber(s, i);
                i += num.length();
                numStack.push(Integer.parseInt(num));
                
                if(!opStack.isEmpty() && opStack.peek() == '*') {
                    int n2 = numStack.pop();
                    int n1 = numStack.pop();
                    opStack.pop();
                    numStack.push(n1 * n2);
                } else if(!opStack.isEmpty() && opStack.peek() == '/') {
                    int n2 = numStack.pop();
                    int n1 = numStack.pop();
                    opStack.pop();
                    numStack.push(n1 / n2);
                }
            }
            
            else {
                if(ch == '-'){
                    opStack.push('+');
                    i++;
                    String num = getNumber(s, i);
                    i += num.length();
                    numStack.push(-1 * Integer.parseInt(num));
                } else {
                    opStack.push(ch);
                    i++;
                }
                
                
            }
        }
        
        return solveRest(numStack, opStack);
    }
}