class Solution {
    
    class Node {
        String ch;
        int count;
        
        Node(String ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    
    public int getLastIndexCurrElement(int start, String formula){
        int n = formula.length();
        
        if(start == n-1){
            return n-1;
        }
        
        int j = start + 1;
        
        char ch = formula.charAt(j);
        // System.out.println(ch);
        while(Character.isLowerCase(ch) && !Character.isDigit(ch) && ch != '(' && ch != ')' && j < n){
            // ch = formula.charAt(j);
            j++;
            if(j < n){
                ch = formula.charAt(j);
            }
        }
        
        // System.out.println("inside" + j);
        return j-1;
    }
    
    public boolean numPossible(int start, String formula){
        int n = formula.length();
        if(start > n-1){
            return false;
        }
        
        char ch = formula.charAt(start);
        
        if(!Character.isDigit(ch))
            return false;
        
        return true;
    }
    
    public String generateResult(Stack<Node> st){
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<String> all = new ArrayList<>();
        while(!st.isEmpty()){
            Node curr = st.pop();
            map.put(curr.ch, map.getOrDefault(curr.ch, 0)+curr.count);
        }
        
        for(String key: map.keySet()){
            all.add(key);
        }
        
        Collections.sort(all);
        for(String s: all){
            sb.append(s);
            if(map.get(s) > 1){
                sb.append(map.get(s));
            }
        }
        
        return sb.toString();
    }
    
    public int getCount(int start, String formula){
        int n = formula.length();
        
        if(start == n-1){
            return n-1;
        }
        
        int j = start + 1;
        char ch = formula.charAt(j);
        while(Character.isDigit(ch) && ch != '(' && ch != ')' && j < n){
            j++;
            
            if(j < n){
                ch = formula.charAt(j);
            }
        }
        
        return j-1;
    }
    
    public String countOfAtoms(String formula) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> aux = new Stack<>();
        
        int i =0, n = formula.length();
        int j = 0, num = 1, k =0;
        while(i < n){
            //start, end
            j = getLastIndexCurrElement(i, formula);
            // System.out.println("j" + j);
            k = j;
            
            String str = formula.substring(i, j + 1);
            // System.out.println(str);
            
            if(str.equals("(")){
                st1.push(new Node("(", 0));  
                i++;
            } 
            
            else if (str.equals(")")) {
                
                if(numPossible(j+1, formula)){
                    k = getCount(j+1, formula);
                    num = Integer.parseInt(formula.substring(j+1, k+1));
                    i = k+1;
                } else {
                    num = 1;
                    i = j+1;
                }
                
                while(!st1.isEmpty() && !st1.peek().ch.equals("(")){
                    Node temp = st1.pop();
                    temp.count *= num;
                    aux.push(temp);
                }
                
                st1.pop();
                
                while(!aux.isEmpty()){
                    st1.push(aux.pop());
                }
                
            } 
            
            else {
                //start, end
                if(numPossible(j+1, formula)){
                    k = getCount(j+1, formula);
                    num = Integer.parseInt(formula.substring(j+1, k+1));
                    i = k+1;
                } else {
                    num = 1;
                    i = j+1;
                }
                
                if(!st1.isEmpty() && st1.peek().ch.equals(str)){
                    st1.peek().count += num;
                } else{
                    st1.push(new Node(str, num));
                }
            }
            
        }
        
//         while(!st1.isEmpty()){
//             Node curr = st1.pop();
//             System.out.println(curr.ch + " " + curr.count);
//         }
        
//         return "";
        return generateResult(st1);
    }
}