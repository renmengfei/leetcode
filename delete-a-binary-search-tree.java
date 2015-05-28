public class Solution {
    private void myDeleteNode(TreeNode parent, TreeNode node) {
        if (node.left == null) {
            if (parent.right == node) {
                parent.right = node.right;
            } else {
                parent.left = node.right;
            }
        } else {
            TreeNode maxNodeParent = node;
            TreeNode maxNode = node.left;
	
	// find the maximum node in the left sub tree
            while (maxNode.right != null) {
                maxNodeParent = maxNode;
                maxNode = maxNode.right;
            }

	if (maxNodeParent.left == maxNode) {
	    maxNodeParent.left = maxNode.left;
	} else {
    maxNodeParent.right = maxNode.left;
	}

// move replacedNode to node
maxNode.left = node.left;
maxNode.right = node.right;
if (parent.left == node) {
    parent.left = maxNode;
} else {
    parent.right = maxNode;
}
        }
    }

    private void findAndDelete(TreeNode parent, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            myDeleteNode(parent, node);
        } else if (node.val < val) {
            findAndDelete(node, node.right);
        } else {
            findAndDelete(node, node.left);
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int val) {
        TreeNode dummyNode = new TreeNode();
        dummyNode.left = root;
        findAndDelete(dummyNode, root);
        return dummyNode.left;
    }
}

