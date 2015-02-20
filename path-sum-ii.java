// Method 1: recursive
public class Solution {

   public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		pathSum(root, result, new ArrayList<Integer>(), sum);
		return result;
	}

	public void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			// Bug: deep copy
			List<Integer> nextpath = new ArrayList<Integer>(path);
			nextpath.add(root.val);
			result.add(nextpath);
			return;
		}

		List<Integer> nextpath = new ArrayList<Integer>(path);
		nextpath.add(root.val);
		pathSum(root.left, result, nextpath, sum - root.val);
		pathSum(root.right, result, nextpath, sum - root.val);
	}
}



// Method 2: iterator
public class Solution {
 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> relts = new ArrayList<List<Integer>>();
	    if (root == null) {
	        return relts;
	    }

	    List<Integer> path = new ArrayList<Integer>();
	    Stack<TreeNode> s = new Stack<TreeNode>();
	    TreeNode cur = root;
	    // bug: last is important. 需要记录何时遍历到最右边了 ｛－2，＃－3｝，－2
	    TreeNode last = null;
	    int partialSum = 0;

	    while (!s.empty() || cur != null) {
	       if(cur!=null){
	    	   s.add(cur);
	    	   path.add(cur.val);
	    	   partialSum+=cur.val;
	    	   if(cur.left==null&&cur.right==null){
	    		   if(partialSum == sum){
	    			   relts.add(path);
	    			   path = new ArrayList<Integer>(path);
	    		   }
	    	   }
	    	   cur= cur.left;
	       }
	       else{
	    	   TreeNode tmp = s.peek();
	    	   if(tmp.right!=null&&tmp.right!=last){
	    		   cur=tmp.right;
	    	   }
	    	   else{
	    		   last = s.pop();
	    		   int value = path.get(path.size()-1);
	    		   path.remove(path.size()-1);
	    		   partialSum-=value;
	    	   }
	       }
	    }
	    return relts;
	}
}
