// pre-order
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NN).append(spliter);
            return;
        }
        
        sb.append(root.val).append(spliter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        String[] list = data.split(spliter);
        q.addAll(Arrays.asList(list));
        
        return buildTree(q);
    }
    
    
    public TreeNode buildTree(Queue<String> q){
        String cur = q.poll();
        if(cur.equals(NN)) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }
}
