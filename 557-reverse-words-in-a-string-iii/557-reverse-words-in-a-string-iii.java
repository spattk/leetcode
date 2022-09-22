class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String result = "";
        for(String str: arr){
            result += new StringBuilder(str).reverse().toString() + " ";
        }
        
        return result.substring(0, result.length()-1);
    }
}