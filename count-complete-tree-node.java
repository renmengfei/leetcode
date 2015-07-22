public class Solution {
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        if(h==0) return 0;
        
        int hr = getHeight(root.right);
        
        if(hr==h-1) return (1<< h-1) + countNodes(root.right);
        return countNodes(root.left)+(1<< h-2);
    }
    
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        return 1+getHeight(root.left);
    }
}
