public class Solution {
// Method 1: queue
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
		Queue<TreeNode> leftq = new LinkedList<TreeNode>();
		Queue<TreeNode> rightq = new LinkedList<TreeNode>();
		
		leftq.add(root.left);
		rightq.add(root.right);
		
		while(!leftq.isEmpty()&&!rightq.isEmpty()){
			TreeNode l=leftq.poll();
			TreeNode r = rightq.poll();
			if(l==null&&r==null) continue;
			if(l==null&&r!=null) return false;
			if(l!=null&&r==null) return false;
			if(l.val!=r.val) return false;
			leftq.add(l.left);
			leftq.add(l.right);
			rightq.add(r.right);
			rightq.add(r.left);
		}
		
		return true;
    }
}

// Method 2: recursive
 public boolean isSymmetric(TreeNode root) {
      if(root==null) return true;
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode left, TreeNode right){
        if(left==null && right!=null) return false;
        if(left!=null&& right==null) return false;
        if(left==null && right== null) return true;
        if(left.val!=right.val) return false;// order is also important, 先判断null再判断val
        return isSym(left.left,right.right) && isSym(left.right, right.left);
    }
