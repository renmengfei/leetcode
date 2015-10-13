Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

//Method 1: recursion
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int prevval = root.val;
        
        TreeNode cur = prevval>target? root.left: root.right;
        if(cur==null) return prevval;
        
        int curval = closestValue(cur, target);
        return Math.abs(prevval-target)<Math.abs(curval-target)?prevval: curval;
    }
}


// Method 2: iteration
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        
        TreeNode ptr = root;
        while(ptr!=null){
            if(Math.abs(ptr.val-target)<Math.abs(result-target)){
                result = ptr.val;
            }
            if(target<ptr.val) ptr = ptr.left;
            else if(target>ptr.val) ptr = ptr.right;
            else break;
        }
        
        return result;
    }
}

