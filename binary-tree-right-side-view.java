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
