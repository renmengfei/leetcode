// O(N) time, O(1) space
//循环体：
// ptr.left = parentRight;
// ptr.right = parent;
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
		while(p!=null){
			TreeNode left = p.left;
			TreeNode right = p.right;
			p.left = parentRight;
			p.right = parent;
			parentRight = right;
			parent = p;
			p = left;
			
		}
		return parent;
    }
}
