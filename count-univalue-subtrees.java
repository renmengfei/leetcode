public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
       all(root);
       return count;
    }
    
    public boolean all(TreeNode root){
        if(root==null) return true;
        
        boolean left = all(root.left);
        boolean right = all(root.right);
        
        if(left&& right){
            if(root.left!=null && root.val!=root.left.val) return false;
            if(root.right!=null && root.val!=root.right.val) return false;
            count++;
            return true;
        }
        return false;
    }
}


//我的错误方法
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        int countl = countUnivalSubtrees(root.left);
        int countr = countUnivalSubtrees(root.right);
        
        if(countl==0 && countr==0 ) return 0;
        if(countl!=0 && root.left.val!=root.val) return countl+countr;
        if(countr!=0 && root.right.val!=root.val) return countl+countr;
        
        return countl + countr + 1;
    }
}

问题所在，不能直接用count来recursion，例子

   79
79
   -97

第二个79的count=1，但如果带到第一个79，就变成1+1=2,考虑value的时候没有考虑孙子
