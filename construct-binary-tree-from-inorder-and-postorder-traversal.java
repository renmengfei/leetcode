	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode build(int[] inorder, int ins, int ine, int[] postorder, int posts, int poste) {
		if (ins > ine || posts > poste)
			return null;
		int rootval = postorder[poste];
		TreeNode root = new TreeNode(rootval);

		int index = getIndex(inorder, rootval);
		root.left = build(inorder, ins, index - 1, postorder, posts, posts + index - ins - 1);
		root.right = build(inorder, index + 1, ine, postorder, posts + index - ins, poste - 1);
		return root;
	}

	public int getIndex(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}
