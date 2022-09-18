class Solution {
    public int calculate(String s) {
        char lastOp = '+';
        int n = s.length();
        int lastNumber = 0, currNumber = 0 ,result = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                currNumber = currNumber * 10 + (ch - '0');
            }
            
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == n-1) {
                if(lastOp == '+') {
                    result += lastNumber;
                    lastNumber = currNumber;
                } else if (lastOp == '-') {
                    result += lastNumber;
                    lastNumber = -1 * currNumber;
                } else if (lastOp == '*') {
                    lastNumber *= currNumber;
                } else if (lastOp == '/') {
                    lastNumber /= currNumber;
                }
                
                lastOp = ch;
                currNumber = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
}