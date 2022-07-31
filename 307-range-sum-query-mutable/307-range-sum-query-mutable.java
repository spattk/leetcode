class NumArray {
    
    class SegtreeNode {
        int start, end;
        SegtreeNode left, right;
        int sum;
        
        SegtreeNode(int s, int e){
            start = s;
            end = e;
            left = null;
            right = null;
            sum = 0;
        }
    }
    
    SegtreeNode root = null;

    public SegtreeNode buildTree(int[] nums, int s, int e){
        if(s > e)
            return null;
        else {
            SegtreeNode ret = new SegtreeNode(s, e);
            if(s == e){
                ret.sum = nums[s];
            } else {
                int mid = (s + e)/2;
                ret.left = buildTree(nums, s, mid);
                ret.right = buildTree(nums, mid+1, e);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    public void updateHelper(SegtreeNode root, int pos, int val){
        //we have to update the leaf
        if(root.start == root.end){
            root.sum = val;
        } else {
            int mid = (root.start + root.end)/2;
            if(pos <= mid){
                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    public int sumRangeHelper(SegtreeNode root, int left, int right){
        //full overlap
        if(root.start == left && root.end == right){
            return root.sum;
        } else {
            int mid = (root.start + root.end)/2;
            if(right <= mid){
                return sumRangeHelper(root.left, left, right);
            } else if(left >= mid+1){
                return sumRangeHelper(root.right, left, right);
            } else {
                return sumRangeHelper(root.left, left, mid) + sumRangeHelper(root.right, mid+1, right);
            }
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */