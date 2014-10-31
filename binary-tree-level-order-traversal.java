public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        level(root,0,result);
        return result;
    }
    
    public void level(TreeNode root, int level, List<List<Integer>> result){
        if(root==null) return;
        
        if(result.size()<=level){
            List<Integer> newarray = new ArrayList<Integer>();
            result.add(newarray);
        }
        result.get(level).add(root.val);
        level(root.left, level+1, result);
        level(root.right, level+1, result);
        
    }
}
