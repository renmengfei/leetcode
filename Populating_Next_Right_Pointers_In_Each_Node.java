/*
* Perfect Binary Tree
* Populate each next pointer to point to its next right node.
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode parent = root;
        while(parent.left!=null){
            TreeLinkNode child = parent.left;
            while(parent!=null){
                parent.left.next = parent.right;
                if(parent.next!=null){
                    parent.right.next=parent.next.left;
                }
                parent = parent.next;
            }
            parent = child;
        }
    }
}
