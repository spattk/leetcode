class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        while (i<n && j<n){
            int temp = nums[j];
            if (map.getOrDefault(temp,0) == 0){
                map.put(temp, 1);
                sum += temp;
                max = Math.max(max, sum);
            } else {
                while(i<n){
                    if (nums[i] == temp){
                        i++;
                        sum -= temp;
                        break;
                    } else {
                        sum -= nums[i];
                        map.put(nums[i], map.get(nums[i])-1);
                        i++;
                    }
                }
                sum += temp;
                max = Math.max(max, sum);
            }
            j++;
        }
        max = Math.max(max, sum);
        return max;
    }
}