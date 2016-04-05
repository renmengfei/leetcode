// Method 1: 用stack的深度
public class Solution {
    public boolean isValidSerialization(String preorder) {
        int depth = 0;
        if(preorder==null || preorder.isEmpty()) return false;
        String [] lists = preorder.split(",");

        int i=0;
        while(i<lists.length-1) {
            if(lists[i++].equals("#")){
                if(depth==0) return false;
                depth--;
            }
            else{
                depth++;
            }
        }
        
        if(depth!=0) return false;
        return lists[i].equals("#");
    }
}

// Method 2: stack
public boolean isValidSerialization(String preorder) {
    String[]a = preorder.split(",");

    Stack<String> stack = new Stack<String>();
    for(int i = 0; i<a.length; i++){
        String cur = a[i];
        if(cur.equals("#")){
            while(!stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
            stack.push("#");
        }else{
            stack.push(cur);
        }
    }
    return stack.size()==1 && stack.peek().equals("#");
}

