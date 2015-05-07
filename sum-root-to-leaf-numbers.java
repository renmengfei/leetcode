// Recursive, Bug, cannot add root before checking the children.
// Input {9} -> may lead to {9+9=18}
public class Solution {
    public int sumNumbers(TreeNode root) {
		return sumNum(root,0);
    }

    public int sum(TreeNode n, int s){
	//bug: return 0!!!
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
	
}
