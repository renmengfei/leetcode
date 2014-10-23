public class Solution {
    // Method 1: recursivly.
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> re = new ArrayList<Integer>();
    //     inorder(root, re);
    //     return re;
    // }
    // public void inorder(TreeNode root, List<Integer> list){
    //     if(root==null) return;
    //     inorder(root.left, list);
    //     list.add(root.val);
    //     inorder(root.right, list);
    // }
    
    //Method 2: Iterativly 
     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode ptr = root;
        
        while(true){
            while(ptr!=null){
                s.push(ptr);
                ptr=ptr.left;
            }
            if(s.isEmpty()) break;
            ptr=s.pop();
            result.add(ptr.val);
            ptr=ptr.right;
        }
        return result;
    }
}
