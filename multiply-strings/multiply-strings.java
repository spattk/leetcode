class Solution {
    
    public String add(String num1, String num2){
        int n1 = num1.length();
        int n2 = num2.length();
        
        int i=0,j=0;
        int carry = 0;
        String res = "";
        while(i<n1 && j<n2){
            int p = num1.charAt(i) -'0';
            int q = num2.charAt(i) - '0';
            int sum = p + q + carry;
            res += sum %10;
            carry = sum/10;
            i++; j++;
        }
        
        while(i<n1){
            int p = num1.charAt(i)-'0';
            int sum = carry + p;
            res += sum %10;
            carry = sum/10;
            i++;
        }
        
        while(j<n2){
            int q = num2.charAt(j)-'0';
            int sum = carry + q;
            res += sum %10;
            carry = sum/10;
            j++;
        }
        
        if(carry != 0)
            res += carry;
        
        return res;
    }
    
    public String checkZeroes(StringBuilder str){
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '0' && !start)
                continue;
            else{
                start = true;
                sb.append(ch);
            }
        }
        
        if(sb.length() == 0)
            return "0";
        
        return sb.toString();
    }
    
    
    
    public String multiply(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        sb1.reverse(); 
        num1 = sb1.toString();
        
        StringBuilder sb2 = new StringBuilder(num2);
        sb2.reverse();
        num2 = sb2.toString();

        int n1 = num1.length();
        int n2 = num2.length();
        int k = 0;
        String res = "";
        for(int i=0;i<n1;i++){
            // System.out.println(res);
            String ans = "";
            for(int z=k;z>0;z--)
                ans += "0";
            int p = num1.charAt(i) - '0';
            // System.out.println("p" + p);
            int carry = 0;
            for(int j=0;j<n2;j++){
                
                int q = num2.charAt(j) - '0';
                // System.out.println("q" + q);
                int mul = p * q + carry;
                ans += mul%10;
                carry = mul/10;
            }
            if(carry != 0)
                ans += carry;
            
            res = add(res, ans);
            k++;
        }
        
        // res = checkZeroes(res);
        
        StringBuilder sb = new StringBuilder(res);
        sb.reverse();
        return checkZeroes(sb);
    }
}