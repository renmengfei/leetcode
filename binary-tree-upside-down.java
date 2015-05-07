Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Input:
    1
   / \
  2   3
 / \
4   5
Output:
   4
  / \
 5   2
    / \
   3   1  

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
