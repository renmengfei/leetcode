public class Solution {
// Method 1: Recursive
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
   		// bug, must add null， 否则size＝＝0
		if (start > end) {
			list.add(null);
			return list;
		}
		if (start == end) {
			TreeNode root = new TreeNode(start);
			list.add(root);
			return list;
		}
		for (int i = start; i <= end; i++) {

			List<TreeNode> l = generateTrees(start, i - 1);
			List<TreeNode> r = generateTrees(i + 1, end);
			for (int m = 0; m < l.size(); m++) {
				for (int n = 0; n < r.size(); n++) {
					TreeNode root = new TreeNode(i);
					root.left = l.get(m);
					root.right = r.get(n);
					list.add(root);
				}
			}
		}
		return list;
	}
}

