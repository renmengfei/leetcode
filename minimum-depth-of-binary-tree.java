// Method 1: recursive
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}

// Method 2: iterative
// endOfLevel is important
    public int minDepth(TreeNode root) {
      if(root==null) return 0;

      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);
      TreeNode endOfLevel = root;
      int depth = 1;

      while( !queue.isEmpty() ) {
          TreeNode node = queue.remove();
          if(node.left==null && node.right==null) return depth;
          if(node.left!=null) queue.add(node.left);
          if(node.right!=null)  queue.add(node.right);
          if(node == endOfLevel) {
              endOfLevel = node.right==null ? node.left : node.right;
              depth++;
          }
      }
      return depth;
    }
