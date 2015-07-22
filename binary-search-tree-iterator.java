//Method 1:
public class BSTIterator {
        Stack<TreeNode> stack =  null ;            
        TreeNode current = null ;

        public BSTIterator(TreeNode root) {
              current = root;        
              stack = new Stack<> ();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {        
	      // bug: current!=null is VERY INMPORTANT!
              return !stack.isEmpty() || current != null;  
        }

            /** @return the next smallest number */
        public int next() {
            while (current != null) {
                stack.push(current);
                current = current.left ;
            }       
            TreeNode t = stack.pop() ;      
            current = t.right ;     
            return t.val ;
        }
    }


// Method 2
public class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = s.pop();
        pushAll(cur.right);       
        return cur.val;
    }
    
    public void pushAll(TreeNode node){
        while(node!=null){
            s.push(node);
            node = node.left;
        }
    }
}
