// verify inorder:只是看array是不是顺序的
// verify preorder 重点是记录predecessor
// verify postorder 重点是记录successor

// Method 1: stack
// 重点：记录前继predecessor, 当pop一堆东西出来，找到前继后，后面的数都要比前继大。这个是判断点
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null || preorder.length<2) return true;
        Stack<Integer> s = new Stack<Integer>();
        
        int pre=Integer.MIN_VALUE;
        
        for(int p: preorder){
            if(p<pre) return false;
            
            while(!s.isEmpty() && s.peek()<p){
                pre=s.pop();
            }
            s.push(p);
        }
        return true;
    }
}

// Method 2: O(1) space
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null || preorder.length<2) return true;
        
        int pre=Integer.MIN_VALUE;
        int i=-1;
        
        for(int p: preorder){
            if(p<pre) return false;
            
            while(i>=0 && preorder[i]<p){
                pre=preorder[i--];
            }
            
            preorder[++i] = p;
        }
        return true;
    }
}


// ============ verify postorder
//这个方法有点傻
    public static boolean verifyPostorder(int[] postorder, int n) {
        if (postorder == null || n <= 0)
            return false;
        
        int root = postorder[n - 1];

        int left = 0;
        for (; left < n - 1; left++) {
            if (postorder[left] > root)
                break;
        }

        for (int right = left; right < n - 1; ++right) {
            if (postorder[right] < root)
                return false;
        }

        boolean l_valid = true, r_valid = true;
        if (left > 0)
            l_valid = verifyPostorder(postorder, left);
        if (left < n - 1){
            int[] tmp = new int[n-left-1];
            System.arraycopy(postorder, left, new int[n-left-1], 0, n-left-1);
            r_valid = verifyPostorder(tmp, n - left - 1);
        }
           

        return l_valid && r_valid;
    }
