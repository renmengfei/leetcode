// Recursive, Bug, cannot add root before checking the children.
// Input {9} -> may lead to {9+9=18}
public class Solution {
    public int sumNumbers(TreeNode root) {
		return sumNum(root,0);
	}
	
	public int sumNum(TreeNode root, int father){
		if(root==null) {
			return 0;
		}
		int cur = father*10 + root.val;
		int sum = sumNum(root.left, cur) + sumNum(root.right,cur);
		if(sum==0) return cur;
		else return sum;
	}
}
