class Solution {
	Map<Integer, List<Integer>> heightMap;

	public int calculateHeightMap(TreeNode root){
		if(root == null){
			return -1;
		}

		int lh = calculateHeightMap(root.left);
		int rh = calculateHeightMap(root.right);

		int h = Math.max(lh, rh) + 1;

		heightMap.putIfAbsent(h, new ArrayList<>());
		heightMap.get(h).add(root.val);

		return h;

	}

    	public List<List<Integer>> findLeaves(TreeNode root) {
     		heightMap = new HashMap<>();
		calculateHeightMap(root);

		List<Integer> keys = new ArrayList<>(heightMap.keySet());
		Collections.sort(keys);

		List<List<Integer>> answer = new ArrayList<>();
		for(int key: keys){
			answer.add(heightMap.get(key));
		}

		return answer;
    	}
}

