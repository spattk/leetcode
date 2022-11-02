class Solution {
    
    public void replaceAndAdd(Queue<String> q, char[] chs, int i, char ch, Set<String> bankSet, Set<String> visited ){
        chs[i] = ch;
        String str = new String(chs);
        
        if(bankSet.contains(str) && !visited.contains(str)){
            visited.add(str);
            q.add(str);
        }
    }
    
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for(String b: bank)
            bankSet.add(b);
        
        if(start.equals(end))
            return 0;
        
        if(!bankSet.contains(end))
            return -1;
        
        int level = -1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                
                if(curr.equals(end))
                    return level;
                
                char[] chs = curr.toCharArray();
                
                for(int j=0; j<chs.length; j++){
                    char prev = chs[j];
                    replaceAndAdd(q, chs, j, 'A', bankSet, visited);
                    replaceAndAdd(q, chs, j, 'C', bankSet, visited);
                    replaceAndAdd(q, chs, j, 'G', bankSet, visited);
                    replaceAndAdd(q, chs, j, 'T', bankSet, visited);
                    chs[j] = prev;
                }
                
            }
        }
        
        return -1;
    }
}