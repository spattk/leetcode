class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                leftMin++;
                leftMax++;
            }
            else if (ch == ')'){
                leftMin--;
                
                leftMax--;
                
                if(leftMax < 0)
                    return false;
            }
            else {
                //* -> (
                leftMax++;
                
                //* -> )
                leftMin--;
            }
            
            leftMin = Math.max(leftMin, 0);
        }
        
        return leftMin == 0;
    }
}