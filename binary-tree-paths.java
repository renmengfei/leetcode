// path sum ii, 统一模板
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        helper(result, "", root);
        return result;
    }
    
    public void helper(List<String> result, String path, TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null){
            path+=root.val;
            result.add(new String(path));
            return;
        }
        if(root.left!=null){
            helper(result, path+root.val+"->", root.left);
        }
        if(root.right!=null){
            helper(result, path+root.val+"->", root.right);
        }
    }
}
