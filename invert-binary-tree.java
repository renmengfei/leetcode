// Method 1: recursion
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode invertleft = invertTree(root.left);
        TreeNode invertright = invertTree(root.right);
        root.left = invertright;
        root.right = invertleft;
        return root;
    }

//Method 2: DFS, BFS差不多
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;
            
            if(cur.left!=null) s.push(cur.left);
            if(cur.right!=null) s.push(cur.right);
        }
        return root;
    }

