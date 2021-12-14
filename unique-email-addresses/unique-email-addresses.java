class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for(String email: emails){
            StringBuilder sb = new StringBuilder(email);
            int set = -1;
            for(int i=0;i<email.length();i++){
                if(set == -1 && sb.charAt(i) == '.'){
                    sb.deleteCharAt(i);
                } else if(set == 0)
                    break;
                
                if(sb.charAt(i) == '@')
                    set = 0;
            }
            
            int plus = sb.indexOf("+");
            int at = sb.indexOf("@");
            
            String s;
            if(plus != -1){
                String sb1 = sb.substring(0,plus);
                String sb2 = sb.substring(at);
                s = sb1 + sb2;
            } else {
                s = sb.toString();
            }
            res.add(s);
        }
        
        return res.size();
    }
}