class Solution {
    int numCount = 0;
    public int getNumber(String s, int idx){
        int num = 0;
        int i = idx;
        numCount = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            num = num * 10 + (s.charAt(i)- '0');
            i++;
            numCount++;
        }
        
        return num;
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
                int num = getNumber(s, i);
                i += numCount;
                numStack.push(num);
                
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
                    int num = getNumber(s, i);
                    i += numCount;
                    numStack.push(-1 * num);
                } else {
                    opStack.push(ch);
                    i++;
                }
                
                
            }
        }
        
        return solveRest(numStack, opStack);
    }
}