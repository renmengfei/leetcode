// 两个stack，一个存正序，一个存逆序。按merge sort来找k
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        
        
        while(k>0){
            if(s1.isEmpty()){
                res.add(s2.pop());
            }
            else if(s2.isEmpty()){
                res.add(s1.pop());
            }
            else if(Math.abs(target-s1.peek()) > Math.abs(target-s2.peek())){
                res.add(s2.pop());
            }
            else{
                res.add(s1.pop());
            }
            k--;
        }
        
        return res;
    }
    
    
    
    public void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack){
        if(root==null) return;
        
        inorder(reverse?root.right: root.left, target, reverse, stack);
        //一个存等号，一个不存等号
        if(reverse && root.val <= target) return;
        if(!reverse && root.val>target) return;
        stack.add(root.val);
        inorder(reverse? root.left: root.right, target, reverse, stack);
        
    }
}
