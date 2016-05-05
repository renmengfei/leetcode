public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                stack.add(stack.pop()+stack.pop());
            }
            else if(s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a / b);
            }
            else if(s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            }
            else if(s.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a - b);
            }
            else {
                stack.add(Integer.parseInt(s));
            }
        }   
        return stack.pop();
    }
}
