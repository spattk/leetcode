class Solution {
    
    Map<Character, Long> count;
    Map<Character, List<Character>> adj;
    
    public void init(){
        count = new HashMap<>();
        count.put('a',1L);
        count.put('e',1L);
        count.put('i',1L);
        count.put('o',1L);
        count.put('u',1L);
        
        adj = new HashMap<>();
        List<Character> list = new ArrayList<>();
        list.add('e');
        adj.put('a', list);
        
        list = new ArrayList<>();
        list.add('a');
        list.add('i');
        adj.put('e', list);
        
        list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('o');
        list.add('u');
        adj.put('i', list);
        
        list = new ArrayList<>();
        list.add('i');
        list.add('u');
        adj.put('o', list);
        
        list = new ArrayList<>();
        list.add('a');
        adj.put('u', list);
        
    }
    
    public int mapCounter(Map<Character, Long> map){
        long count = 0;
        long mod = (long)1e9 + 7;
        for(char ch: map.keySet()){
            count += map.get(ch);
            count %= mod;
        }
        
        return (int)count;
    }
    
    public int countVowelPermutation(int n) {
        int k = 1;
        long mod = (long)1e9 + 7;
        init();
        while(k < n){
            Map<Character, Long> currMap = new HashMap<>();
            for(char ch: count.keySet()){
                for(char nei: adj.get(ch)){
                    long newCount = currMap.getOrDefault(nei, 0L) + count.get(ch);
                    newCount %= mod;
                    currMap.put(nei, newCount);
                }
            }
            // System.out.println(currMap);
            count = currMap;
            k++;
        }
        
        // System.out.println(count);
        
        return mapCounter(count);
        
        
    }
}