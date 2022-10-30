class Solution {
	class SegtreeNode{
		int start, end, count;
		SegtreeNode left, right;

		SegtreeNode(int s, int e){
			this.start = s;
			this.end = e;
            this.count = 0;
		}
	}

	SegtreeNode root = null;

	public SegtreeNode buildTree(int s, int e){
		if(s > e){
			return null;
		}

		SegtreeNode node = new SegtreeNode(s, e);
		if(s == e){
			node.count = 0;
		}
		else {
			int mid = s + (e -s)/2;
			node.left = buildTree(s, mid);
			node.right = buildTree(mid+1, e);
			node.count = node.left.count + node.right.count;
		}

		return node;
	}

	public void updateHelper(SegtreeNode root, int pos){
		if(root == null)
		return;

		if(root.start == root.end && root.start == pos){
			root.count += 1;
            return;
		}

		int mid = root.start + (root.end - root.start)/2;
		if(pos <= mid){
			updateHelper(root.left, pos);
		}
		else {
			updateHelper(root.right, pos);
		}

		root.count = root.left.count + root.right.count;
	}

	public int countRange(SegtreeNode root, int s, int e){
		if(s > e || root == null){
			return 0;
		}

		if(root.start == s && root.end == e){
			return root.count;
		}
		else {
			int mid = root.start + (root.end - root.start)/2;
			if(s > mid){
				return countRange(root.right, s, e);
			}
			else if(e <= mid){
				return countRange(root.left, s, e);
			}
			else {
				return countRange(root.left, s, mid) + countRange(root.right, mid+1, e);
			}
		}
	}

	public int findMin(int[] nums){
		int min = Integer.MAX_VALUE;
		for(int num: nums){
			min = Math.min(min, num);
		}

		return min;
	}

	public int findMax(int[] nums){
		int max = Integer.MIN_VALUE;
		for(int num: nums){
			max = Math.max(max, num);
		}

		return max;
	}

    public List<Integer> countSmaller(int[] nums) {
     		
		int min = findMin(nums);
		int max = findMax(nums);

		int mN = max-min+1;
        int n = nums.length;
		int [] modNums = new int[mN];
		for(int k=0; k<mN; k++){
			modNums[k] = min+k;
		}

		root = buildTree(min, max);
			
		List<Integer> list = new ArrayList<>();
	
		for(int i=n-1; i>=0; i--){
			updateHelper(root, nums[i]);
			list.add(countRange(root, min, nums[i]-1));
		}

		Collections.reverse(list);
		return list;
    }
}

