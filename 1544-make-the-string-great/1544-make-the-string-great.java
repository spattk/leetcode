class Solution {

	public boolean isValid(Stack<Character> st, char ch){
		if(st.isEmpty())
			return true;

		char c1 = Character.toLowerCase(st.peek());
		char c2 = Character.toLowerCase(ch);
        
        int i1 = (int)st.peek();
        int i2 = (int)ch;
        
	
		return (!(Math.abs(i1-i2) == 32 && c1 == c2) );
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



