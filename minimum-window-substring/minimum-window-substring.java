class Solution {
    public String minWindow(String s, String t) {
        int i=0, j=0, n = s.length(), l = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        // List<String> res = new ArrayList<>();
        String res = "";
        int count = map.size();
        while(i<n && j<n){
            char ch = s.charAt(j);
            if(map.get(ch) != null){
                map.put(ch, map.get(ch)-1);
                
                if(map.get(ch) == 0)
                count--;
            }

            while(count == 0){
                String temp = s.substring(i,j+1);
                if(res.equals(""))
                    res = temp;
                else{
                    if(temp.length() < res.length())
                        res = temp;
                }
                // res.add(s.substring(i,j+1));
                
                ch = s.charAt(i);
                if(map.get(ch) != null){
                    map.put(ch, map.get(ch)+1);
                    if(map.get(ch) >0)
                        count++;
                }
                i++;
            }
            j++;
        }
        
        
        // res.sort((a,b)->a.length()-b.length());
        // System.out.println(res);
        return res;
    }
}