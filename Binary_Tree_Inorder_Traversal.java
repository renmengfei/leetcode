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
        List<Integer> re = new ArrayList<Integer>();
        if(root == null) return re;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        TreeNode ptr = root.left;
        while(!s.isEmpty()){
            while(ptr!=null){
                s.push(ptr);
                ptr = ptr.left;
            }
            
            ptr = s.pop();
            re.add(ptr.val);
            ptr = ptr.right;
            
            if(ptr!=null){
                s.push(ptr);
                ptr = ptr.left;
            }
        }
        
        return re;
    }
}
