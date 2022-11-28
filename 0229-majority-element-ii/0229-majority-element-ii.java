class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer m1 = null, m2 = null;
        int c1 = 0, c2 = 0;
        int n = nums.length;
        
        for(int num: nums){
            if(m1 != null && m1 == num)
                c1++;
            else if(m2 != null && m2 == num)
                c2++;
            
            else if(m1 == null){
                m1 = num;
                c1++;
            }
            else if (m2 == null){
                m2 = num;
                c2++;
            }
            else {
                c1--;
                c2--;
                
                if(c1 == 0)
                    m1 = null;
                
                if(c2 == 0)
                    m2 = null;
            }
        }
        
        c1 = 0;
        c2 = 0;
        
        for(int num: nums){
            if(m1 != null && num == m1){
                c1++;
            }
            if(m2 != null && num == m2){
                c2++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        if(c1 > n/3) list.add(m1);
        if(c2 > n/3) list.add(m2);
        
        return list;
        
    }
}