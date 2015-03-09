// Method 2: build a variable Space O(lg N), Runtime O(n)
public class Solution {
    
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
       node = head;
       int size = 0;
       ListNode ptr = head;
       while(ptr!=null){
           ptr=ptr.next;
           size++;
       }
       return helper(0,size-1);
    }
    
    public TreeNode helper(int start, int end){
      if(start>end) return null;
      int mid = (start+end)/2;
      TreeNode left = helper(start, mid-1);
      TreeNode root = new TreeNode(node.val);
      node = node.next;
      TreeNode right = helper(mid+1,end);
      root.left= left;
      root.right=right;
      return root;
    }
}

public class Solution {
    //bug: java cannot pass reference, so I use an array to wrap the listnode
    public TreeNode sortedListToBST(ListNode head) {
        int n = getLength(head);
        ListNode[] wrap = new ListNode[1];
        wrap[0]=head;
        if(n==0) return null;

        return generateTree(wrap, 0, n-1);
    }

    public int getLength(ListNode head){
        if(head==null) return 0;
        ListNode ptr = head;
        int len = 0;
        while(head!=null){
            head=head.next;
            len++;
        }

        return len;
    }

    public TreeNode generateTree(ListNode[] wrap, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;

        TreeNode left = generateTree(wrap, start, mid-1);
        TreeNode root = new TreeNode(wrap[0].val);
        wrap[0] = wrap[0].next;
        TreeNode right = generateTree(wrap, mid+1, end);
        root.left = left;
        root.right = right;

        return root;
    }
}


