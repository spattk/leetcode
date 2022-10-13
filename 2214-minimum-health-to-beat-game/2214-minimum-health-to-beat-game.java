class Solution {
    public long minimumHealth(int[] damage, int armor) {
        Arrays.sort(damage);
        int n = damage.length;
        
        int maxArmor = 0;
        long sum = 0;
        for(int i=n-1; i>=0; i--){
            sum += damage[i];
            maxArmor = Math.max(maxArmor, Math.min(armor, damage[i]));
        }
        
        return sum - maxArmor + 1;
    }
}