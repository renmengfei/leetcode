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

// Method 2: iterator, use queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int levelsize = q.size();
            for(int i=0;i<levelsize; i++){
                TreeNode tmp = q.poll();
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
                level.add(tmp.val);
            }
            result.add(level);
        }
        return result;
    }
