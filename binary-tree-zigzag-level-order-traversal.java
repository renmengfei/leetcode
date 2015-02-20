// Method 1: recursive
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		levelTraversal(root,0,result);
		return result;
	}
	
	public void levelTraversal(TreeNode root, int level, List<List<Integer>> result){
		if(root==null) return;
		if(level>=result.size()){
			result.add(new ArrayList<Integer>());
		}
		//left to right, append
		if(level%2==0){
			result.get(level).add(root.val);
		}
		else{
			result.get(level).add(0, root.val);
		}
		levelTraversal(root.left,level+1,result);
		levelTraversal(root.right, level+1, result);
	}
}


// Method 2: iterative, using queue
public class Solution {
   	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int cur = 1;
		int next = 0;

		List<Integer> level = new ArrayList<Integer>();
		boolean lefttoright = true;

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode ptr = q.poll();
			if (lefttoright) level.add(ptr.val);
			else level.add(0, ptr.val);

			cur--;
 			// but:先add left， right，再写if(cur==0),不然，无法cur=next
		        if (ptr.left != null) {
				q.add(ptr.left);
				next++;
			}
			if (ptr.right != null) {
				q.add(ptr.right);
				next++;
			}
			if (cur == 0) {
				result.add(level);
				level = new ArrayList<Integer>();
				cur = next;
				next = 0;
				lefttoright = !lefttoright;
			}
		}
		return result;
	}
}
