public class Solution {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root==null) return;
        TreeLinkNode ptr = root;

        while(ptr!=null){
            // bug，在里面设置，level扫描
            TreeLinkNode next = null,prev=null;

            for(;ptr!=null;ptr=ptr.next){
                if(next==null){
                    next = ptr.left==null?ptr.right:ptr.left;
                }
                if(ptr.left!=null){
                    if(prev!=null) prev.next = ptr.left;
                    prev = ptr.left;
                }

                if(ptr.right!=null){
                    if(prev!=null) prev.next=ptr.right;
                    prev=ptr.right;
                }
            }
            ptr = next;
        }
    }
}
