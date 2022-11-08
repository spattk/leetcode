class Solution {
    
    public boolean isDiff(char c1, char c2){
    	return Character.isLowerCase(c1) && Character.isUpperCase(c2);    
    }
    
	public boolean isValid(Stack<Character> st, char ch){
		if(st.isEmpty())
			return true;

		char c1 = Character.toLowerCase(st.peek());
		char c2 = Character.toLowerCase(ch);
        
        int i1 = (int)st.peek();
        int i2 = (int)ch;
        
	
		return (!(c1 == c2 && Math.abs(i1-i2) == 32) );
	}
    
    public String processStack(Stack<Character> st){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }


    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
		for(char ch: s.toCharArray()){
			if(st.isEmpty() || isValid(st, ch)){
				st.push(ch);
			}
			else {
				st.pop();
			}
		}  

		return processStack(st);
    }
}



