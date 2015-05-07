// Method 1: Iterative, BFS
public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int cursize=q.size();
            for(int i=0;i<cursize;i++){
                TreeNode tmp = q.poll();
                if(i==cursize-1){
                    result.add(tmp.val);
                }
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
            }
        }
        return result;
}
//Method 2: recursion
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
	//只take最后一个
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        //先recur右边
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}
