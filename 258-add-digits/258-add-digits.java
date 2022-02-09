class Solution {
    
    
    public int getSum(int num){
        int temp = num;
        int sum = 0;
        while(temp >0){
            sum += temp%10;
            temp = temp/10;
        }
        
        return sum;
    }
    
    
    public int addDigits(int num) {
        num = getSum(num);
        while(num >= 10){
            num = addDigits(num);
        }
        
        return num;
    }
}