public class Solution {
   public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	//bug: min, max必须是long，不然如果root.val＝Integer.MAX_VALUE,就不符合条件了
	public boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if (root == null)
			return true;
		int value = root.val;
		if (value <= minValue || value >= maxValue)
			return false;
		return isValidBST(root.left, minValue, value) && isValidBST(root.right, value, maxValue);
	}
}
