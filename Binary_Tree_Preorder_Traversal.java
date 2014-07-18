public class Solution {
    // Method 1: recursively
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<Integer>();
        preorder(root, re);
        return re;
    }
    public void preorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // method 2: iteratively using stack O(N)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        list.add(root.val);
        // the leftnode could be empty, so add right first.
        if(root.right!=null) stack.push(root.right);
        TreeNode ptr = root.left;
        
        while(true){
            while(ptr!=null){
                list.add(ptr.val);
                if(ptr.right!=null){
                    stack.push(ptr.right);
                }
                ptr=ptr.left;
            }
            if(stack.isEmpty()) break;
            ptr=stack.pop();
        }
        return list;
    }
}
