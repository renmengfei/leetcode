public class Solution {
    // Method 1: recursive
    public void flatten(TreeNode root) {
       if(root==null) return;
       if(root.left!=null){
	    	   flatten(root.left);
		   flatten(root.right);
	    	   TreeNode ptr = root.left;
	    	   while(ptr.right!=null){
	    		   ptr = ptr.right;
	    	   }
	    	   ptr.right = root.right;
		   root.right = root.left;
	           root.left = null;
       }
       else{
    	   flatten(root.right);
       } 
    }
    //Method 2: Stack
	Stack<TreeNode> s = new Stack<TreeNode>();
	TreeNode ptr = root;

	while (ptr != null || !s.isEmpty()) {
		if (ptr.right != null) {
			s.push(ptr.right);
		}
		if (ptr.left != null) {
			ptr.right = ptr.left;
			ptr.left = null;// bug, 必须设为null
		} else if (!s.isEmpty()) {
			TreeNode tmp = s.pop();
			ptr.right = tmp;
		}
		ptr = ptr.right;
	} 
       //Method 3: No Stack
	TreeNode ptr = root;
		
	while(ptr!=null){
		TreeNode right = ptr.right;
		if(ptr.left!=null){
			ptr.right = ptr.left;
			ptr.left=null;
				
			TreeNode cur = ptr;
			while(cur.right!=null){
				cur = cur.right;
			}
			cur.right = right;
		}
		ptr = ptr.right;
	}
}
