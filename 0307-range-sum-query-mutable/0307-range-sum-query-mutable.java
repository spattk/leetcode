class NumArray {

    	class SegtreeNode{
		SegtreeNode left, right;
		int start, end, sum;

		SegtreeNode(int left, int right){
			this.start = left;
			this.end = right;
			this.sum = 0;
			this.left = null;
			this.right = null;
		}
	}
    
	SegtreeNode root = null;
	public SegtreeNode buildTree(int[] nums, int s, int e){
		if(s > e)
			return null;

		SegtreeNode node = new SegtreeNode(s, e);
		if(s == e){
			node.sum = nums[s];
		}
		else {
			int mid = s + (e - s)/2;
			node.left = buildTree(nums, s, mid);
			node.right = buildTree(nums, mid+1, e);;
			node.sum = node.left.sum + node.right.sum;
		}

		return node;
	}

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

	public void updateHelper(SegtreeNode root, int index, int val){
		if(root.start == root.end){
			root.sum = val;
		}
		else {
			int mid = root.start + (root.end - root.start)/2;
			if(index <= mid){
				updateHelper(root.left, index, val);
			}
			else {
				updateHelper(root.right, index, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

	public int sumRangeHelper(SegtreeNode root, int left, int right){
        
		if(root.start == left && root.end == right){
			return root.sum;
		}

		int mid = root.start + (root.end - root.start)/2;
		if(right <= mid){
			return sumRangeHelper(root.left, left, right);
		}
		else if(left > mid){
			return sumRangeHelper(root.right, left, right);
		}
		else {
			return sumRangeHelper(root.left, left, mid) + sumRangeHelper(root.right, mid+1, right);
		}
	}
    
    	public int sumRange(int left, int right) {
     		return sumRangeHelper(root, left, right);
    	}
}


