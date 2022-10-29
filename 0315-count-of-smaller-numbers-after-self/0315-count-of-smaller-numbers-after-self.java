class Solution {
    
    class SegtreeNode {
        int start, end, sum;
        SegtreeNode left, right;
    
        SegtreeNode(int s, int e){
            start = s;
            end = e;
            sum = 0;
        }
    }
    
    SegtreeNode root = null;
    List<Integer> result = new ArrayList<>();
    public SegtreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        
        SegtreeNode node = new SegtreeNode(start, end);
        if(start != end){
            int mid = start + (end - start)/2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
        }
        return node;
    }
    
    public void updateHelper(SegtreeNode root, int pos){
        if(root.start == root.end)
            root.sum += 1;
        else {
            int mid = root.start + (root.end - root.start)/2;
            if(pos <= mid)
                updateHelper(root.left, pos);
            else if(pos > mid)
                updateHelper(root.right, pos);
            
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    int findMin(int[]nums){
        int ans = Integer.MAX_VALUE;
        for(int num: nums)
            if(num < ans)
                ans = num;
        
        return ans;
    }
    
    int findMax(int[]nums){
        int ans = Integer.MIN_VALUE;
        for(int num: nums)
            if(num > ans)
                ans = num;
        
        return ans;
    }
    
    public int getSumHelper(SegtreeNode root, int start, int end){
        
        if(start > end)
            return 0;
        
        if(root.start == start && root.end == end)
            return root.sum;
        else {
            int mid = root.start + (root.end - root.start)/2;
            if(end <= mid)
                return getSumHelper(root.left, start, end);
            else if(start >= mid + 1)
                return getSumHelper(root.right, start, end);
            else
                return getSumHelper(root.left, start, mid) + getSumHelper(root.right, mid+1, end);
        }
    }
    
    
    
    public List<Integer> countSmaller(int[] nums) {
        int min = findMin(nums);
        int max = findMax(nums);
        root = buildTree(nums, min, max);
        for(int i=nums.length-1; i>=0 ;i--){
            updateHelper(root, nums[i]);
            int sum = getSumHelper(root, min, nums[i]-1);
            result.add(sum);
        }
        Collections.reverse(result);
        return result;
    }
}