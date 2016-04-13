// Method 1: initial thought
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        if(isValid(root,Long.MAX_VALUE,Long.MIN_VALUE)) return countTree(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    public boolean isValid(TreeNode root, long max, long min){
        if (root == null) return true;
        if (min >= root.val) return false;
        if (max <= root.val) return false;
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
    
    public int countTree(TreeNode root){
        if(root==null) return 0;
        return 1+countTree(root.left) + countTree(root.right);
    }
}

// Method 2: O(N)就是使用数据结构，记录每次traverse的结果
// 细节非常多
//(1) size=0表示node=null
//(2) size=-1,表示node不是BST
//(3) node=null时，max min互换，
//(4)最后的result，
// int newleft = left.lower==Integer.MAX_VALUE? root.val: left.lower;
// int newright = right.upper==Integer.MIN_VALUE?root.val: right.upper;
//(5)root.val<=left.upper等号的作用，万一left，root，right值相同，应该去掉相同的情况 [6,6,6]
public class Solution {
    class Result { 
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }    
        traverse(root);
        return max;
    }

   
   public Result traverse(TreeNode root){
       //注意min max互换，因为对于null来说，边界范围是无限小
       if(root==null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
       
       Result left = traverse(root.left);
       Result right = traverse(root.right);
       
       // size=-1和size=0不一样，size=0表示node=null，size=-1表示有node，但invalid，所以left或者right其中一个不是bst，当前就作废
       if(left.size==-1 || right.size==-1 || root.val<=left.upper || root.val>=right.lower){
           return new Result(-1, 0, 0);
       }
       int size = 1+left.size+right.size;
       max = Math.max(max, size);
       
       return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
   }
}
