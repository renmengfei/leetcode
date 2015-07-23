//http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
//记忆化搜索
public class Solution {
    // don't set to static
    int maxValue =Integer.MIN_VALUE ;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }
    // 这个递归的特点是，返回值和存储的max不一样。存储的是pathsum，返回的是sidesum
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
