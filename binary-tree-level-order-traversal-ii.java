public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        
        level(result, root, 0);
        return result;
    }
    
    public void level(List<List<Integer>> result, TreeNode root, int level){
        if(root==null) return;
        if(result.size()<=level){
            List<Integer> newlevel = new ArrayList<Integer>();
            result.add(0, newlevel);
        }
        result.get(result.size()-1-level).add(root.val);
        level(result, root.left,level+1);
        level(result,root.right, level+1);
        
    }
}
