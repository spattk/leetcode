class Solution {
    public int getVowelCount(String s, int start, int end, Set<Character> vowels){
        int count = 0;
        char[] chs = s.toCharArray();
        for(int i=start; i<end; i++){
            if(vowels.contains(chs[i]))
                count++;
        }
        return count;
    }
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int n = s.length();
        int vc1 = getVowelCount(s, 0, n/2, vowels);
        int vc2 = getVowelCount(s, n/2, n, vowels);
        
        return vc1 == vc2;
    }
}