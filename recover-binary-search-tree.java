public class Solution {
    TreeNode first = null, second = null;
	TreeNode previous = null;

	public void recoverTree(TreeNode root) {
		inorder(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	public void inorder(TreeNode cur) {
		if (cur == null) return;
		inorder(cur.left);

		if (previous != null && previous.val > cur.val) {
			if (first == null) first = previous;
			second = cur;
		}
		previous = cur;
		inorder(cur.right);
	}
}
