public class Solution {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
	}

	public TreeNode buildTree(int[] preorder, int pres, int pree, int[] inorder, int ins, int ine) {
		if(pres>pree || ins >ine) return null;
		
		int value = preorder[pres];
		TreeNode root = new TreeNode(value);
		int index = getIndex(inorder, value);
		
		root.left = buildTree(preorder,pres+1, index-ins+pres, inorder, ins, index-1);
		root.right = buildTree(preorder,index-ins+pres+1,pree,inorder,index+1, ine);
		return root;
	}
	
	public int getIndex(int [] array, int target){
		int result=-1;
		for(int i=0;i<array.length;i++){
			if(array[i]==target){
				result = i;
			}
		}
		return result;
	}
}
