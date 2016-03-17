//不是单纯的按level奇偶来算。。。。。
// case [4,1,null,2,null,3,null], 应该选4，3

// Method 1: intial thought，rob(root)定义为必须取root.val，缺点，recursion重复计算
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = 0;
    
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
    
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
    
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}

// Method 2:
public class Solution {
    // res[0] root not robbed, res[1] root robbed
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] helper(TreeNode root){
        if(root==null){
            return new int[2];
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}

