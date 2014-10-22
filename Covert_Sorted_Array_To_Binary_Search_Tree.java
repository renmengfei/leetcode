public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0) return null;
        return sorted(num,0,num.length-1);
    }
    
    public TreeNode sorted(int[] num, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left=sorted(num,start,mid-1);
        root.right=sorted(num,mid+1,end);
        return root;
    }
}
