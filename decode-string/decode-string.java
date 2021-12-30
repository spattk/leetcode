class Solution {

    public static boolean isValidNumber(char ch) {
        return !Character.isLetter(ch) && ch != '[' && ch != ']';
    }

    public static boolean isValidCharacter(char ch) {
        return Character.isLetter(ch) && ch != '[' && ch != ']';
    }

    public static String getNumber(String input, int idx) {
        int n = input.length();
        int start = idx;
        while (idx < n && isValidNumber(input.charAt(idx))) {
            idx++;
        }

        return input.substring(start, idx);
    }

    public static String getSubstring(String input, int idx) {
        int n = input.length();
        int start = idx;

        while (idx < n && isValidCharacter(input.charAt(idx))) {
            idx++;
        }

        return input.substring(start, idx);
    }

    public String decodeString(String input) {
        Stack < String > stringStack = new Stack < > ();
        Stack < Integer > countStack = new Stack < > ();

        int n = input.length();
        int i = 0;
        while (i < n) {
            char ch = input.charAt(i);
            // System.out.println("curr : >> " + ch);
            

            if (ch >= '1' && ch <= '9') {
                String num = getNumber(input, i); //20
                countStack.push(Integer.parseInt(num));
                i += num.length();
            } else if (ch == '[') {
                //do nothing
                stringStack.push("[");
                i++;
            } else if (ch == ']') {
                //pop thing
                int count = countStack.pop();
                String temp = "";
                while(!stringStack.isEmpty() && !stringStack.peek().equals("[")){
                    temp = stringStack.pop() + temp;
                }
                if(!stringStack.isEmpty())
                    stringStack.pop();
                
                String currString = temp;

                String result = "";
                while (count-- > 0) {
                    result += currString;
                }


                String topString = "";
                stringStack.push(result);

                i++;
            } else {
                //get the next string
                String substr = getSubstring(input, i);
                stringStack.push(substr);
                i += substr.length();
            }
            
            // System.out.println("str: " + stringStack);
            // System.out.println("count: " +countStack);
        }

        String answer = "";
        while(!stringStack.isEmpty()){
            answer = stringStack.pop() + answer;
        }

        return answer;
    }
}