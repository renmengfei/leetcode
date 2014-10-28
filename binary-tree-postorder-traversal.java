public class Solution {
    //使用一个堆栈，难点，需要记录parent，不然，会重复遍历。遍历完child，遍历parent的时候，又加上parent.left了

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode prev = null;
        while(!s.isEmpty()){
            TreeNode cur = s.peek();
            // When prev is curr‘s parent, we are traversing down the tree. 看左边，再看右边
            if(prev==null||prev.left == cur|| prev.right==cur){
                if(cur.left!=null){
                    s.push(cur.left);
                }
                else if(cur.right!=null){
                    s.push(cur.right);
                }
            }
            //If prev is curr‘s left child, we are traversing up the tree from the left. We look at curr‘s right child.
            else if(cur.left==prev){
                if(cur.right!=null){
                    s.push(cur.right);
                }
            }
            // If prev is curr‘s right child, or prev==cur print & pop
            else{
                list.add(cur.val);
                s.pop();
            }
            prev = cur;
        }
        return list;
    }
}
