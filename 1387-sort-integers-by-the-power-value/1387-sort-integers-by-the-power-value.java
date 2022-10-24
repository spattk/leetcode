class Solution {
    
    Map<Integer, Integer> dp;
        
	public int getSteps(int num){
		
        if(num == 1)
            return 0;
        
        if(dp.get(num) != null){
            return dp.get(num);
        }
		
        int result;
        
        if(num % 2 == 0){
            result =  1 + getSteps(num/2);
        } else {
            result = 1 + getSteps(3*num + 1);
            
        }
            
        dp.put(num, result);
		return result;
	}
	
    public int getKth(int lo, int hi, int k) {
        dp = new HashMap<>();
     	List<int[]> list = new ArrayList<>();
		for(int i=lo; i<=hi; i++){
			list.add(new int[]{i, getSteps(i)});
		}   
    
		Collections.sort(list, (a,b)-> b[1]!=a[1] ?a[1]-b[1]:a[0]-b[0]);
		return list.get(k-1)[0];
    }
}


