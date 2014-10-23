//Method 1: Recursively
public class Solution {
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
}

//Method 2: iteratively
public class Solution {
    public boolean isSymmetric(TreeNode root) {
      
        if(root==null) return true;
        Queue<TreeNode> lq = new LinkedList<TreeNode>();
        Queue<TreeNode> rq = new LinkedList<TreeNode>();
        lq.add(root.left);
        rq.add(root.right);
        TreeNode leftTemp = null;
        TreeNode rightTemp = null;
        while(lq.isEmpty() == false && rq.isEmpty() == false){
            leftTemp = lq.poll();
            rightTemp = rq.poll();
            if(leftTemp == null && rightTemp == null) continue;
            if((leftTemp == null && rightTemp != null) || (leftTemp != null && rightTemp == null))
                return false;
            if(leftTemp.val != rightTemp.val)   return false;
       
        lq.add(leftTemp.left);
        lq.add(leftTemp.right);
        rq.add(rightTemp.right);
        rq.add(rightTemp.left);
        }
        
        return true;
}
