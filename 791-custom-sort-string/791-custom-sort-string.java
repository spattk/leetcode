class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        int k=0;
        for(char ch: order.toCharArray()){
            map.put(ch, k++);
        }
        
        Character[] arr = new Character[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                return map.getOrDefault(c1, 500) - map.getOrDefault(c2, 500);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(char ch: arr){
            sb.append(ch);
        }
        
        return sb.toString();
    }
}