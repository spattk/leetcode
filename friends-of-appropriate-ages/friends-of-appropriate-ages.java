class Solution {
    public boolean isFriend(int a, int b){
        if (b <= 0.5*a + 7)
            return false;
        
        if(b > a)
            return false;
        
        return true;
    }
    
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int age: ages){
            map.put(age, map.getOrDefault(age,0)+1);
        }
        
        int res = 0;
        for(int ageA: map.keySet()){
            for(int ageB: map.keySet()){
                int n1 = map.get(ageA);
                int n2 = map.get(ageB);
                
                if(!isFriend(ageA, ageB))
                    continue;
                
                if(ageA == ageB){
                    res += (n1) * (n1-1);
                } else {
                    res += n1 * n2;
                }
            }
        }
        
        return res;
    }
}